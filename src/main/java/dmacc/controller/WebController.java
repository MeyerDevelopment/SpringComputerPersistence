package dmacc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Computer;
import dmacc.repository.ComputerRepository;

@Controller
public class WebController {
	@Autowired
	ComputerRepository repo;
	
	@GetMapping("/viewAll")
	public String viewAllComputers(Model model) {
	model.addAttribute("computers", repo.findAll());
	return "results";
	}
	
	@GetMapping("/inputComputer")
	public String addNewContact(Model model) {
	 Computer c = new Computer();
	 model.addAttribute("newComputer", c);
	 return "input";
	}
	
	@PostMapping("/inputComputer")
	public String addNewComputer(@ModelAttribute Computer c,
	Model model) {
	repo.save(c);
	model.addAttribute("computers", repo.findAll());
	return "results";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id,
	Model model) {
	 Computer c = repo.findById(id)
	 .orElseThrow(() -> new
	IllegalArgumentException("Invalid user Id:" + id));

	 model.addAttribute("computers", c);
	 return "update";
	}
	
	@PostMapping("/update/{id}")
	public String updateComputer(@PathVariable("id") long id,
	@Valid Computer c,
	 BindingResult result, Model model) {
	 if (result.hasErrors()) {
	 c.setId(id);
	 return "update";
	 }
	 repo.save(c);
	 model.addAttribute("computers", repo.findAll());
	return "results";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model
	model) {
	 Computer c = repo.findById(id)
	 .orElseThrow(() -> new
	IllegalArgumentException("Invalid user Id:" + id));
	 repo.delete(c);
	 model.addAttribute("computers", repo.findAll());
	return "results";
	}
}
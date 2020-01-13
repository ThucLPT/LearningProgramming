package pkg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pkg.entity.Event;
import pkg.service.EventService;

@Controller
public class EventController {
	@Autowired
	private EventService eventService;

	@GetMapping("")
	public String index() {
		return "index";
	}

	@GetMapping("list")
	public String findAll(Model model) {
		model.addAttribute("events", eventService.findAll());
		return "list";
	}

	@GetMapping("create")
	public String create(Model model) {
		model.addAttribute("event", new Event());
		return "form";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("event", eventService.findById(id));
		return "form";
	}

	@PostMapping("save")
	public String save(@ModelAttribute Event event) {
		eventService.save(event);
		return "redirect:/list";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		eventService.deleteById(id);
		return "redirect:/list";
	}
}

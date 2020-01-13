package pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pkg.entity.Tag;
import pkg.service.TagService;

@Controller
public class TagController {
	@Autowired
	private TagService service;

	@GetMapping("")
	public String index() {
		return "index";
	}

	@PostMapping("save")
	public String save(@RequestParam("text") String text) {
		Tag tag = service.findByText(text);
		if (tag != null) {
			tag.setUse(tag.getUse() + 1);
			service.save(tag);
		} else {
			Tag newTag = new Tag(text, 1);
			service.save(newTag);
		}
		return "redirect:/";
	}

	@GetMapping("findAll")
	@ResponseBody
	public List<Tag> findAll() {
		return service.findAll();
	}
}

package pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pkg.entity.*;
import pkg.service.*;

@Controller
public class BaseController {
	@Autowired
	private CityService cityService;
	@Autowired
	private DistrictService districtService;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("cities", cityService.findAll());
		return "index";
	}

	@GetMapping("getDistricts/{id}")
	@ResponseBody
	public List<District> getDistrictsFromCity(@PathVariable int id) {
		return cityService.findById(id).getDistricts();
	}

	@GetMapping("getWards/{id}")
	@ResponseBody
	public List<Ward> getWardsFromDistrict(@PathVariable int id) {
		return districtService.findById(id).getWards();
	}
}

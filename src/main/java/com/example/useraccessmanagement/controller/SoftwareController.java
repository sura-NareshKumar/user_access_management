package com.example.useraccessmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.useraccessmanagement.model.Software;

public class SoftwareController {
	@PostMapping("/admin/software")
	public String createSoftware(@RequestParam String name, 
	                             @RequestParam String description,
	                             @RequestParam List<String> accessLevels) {
	    Software software = new Software();
	    software.setName(name);
	    software.setDescription(description);
	    software.setAccessLevels(String.join(",", accessLevels));
	    softwareRepository.save(software);
	    return "redirect:/admin/software";
	}

}

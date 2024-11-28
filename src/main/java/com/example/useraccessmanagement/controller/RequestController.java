package com.example.useraccessmanagement.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.useraccessmanagement.model.Request;
import com.example.useraccessmanagement.model.Software;
import com.example.useraccessmanagement.model.User;
import com.example.useraccessmanagement.repository.RequestRepository;
import com.example.useraccessmanagement.repository.SoftwareRepository;
import com.example.useraccessmanagement.repository.UserRepository;

import ch.qos.logback.core.model.Model;

public class RequestController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SoftwareRepository softwareRepository;
	@Autowired
	private RequestRepository requestRepository;

	@GetMapping("/employee/request")
	public String showRequestForm(Model model) {
	    model.addAttribute("softwareList", softwareRepository.findAll());
	    return "requestAccess";
	}

	@PostMapping("/employee/request")
	public String submitRequest(@RequestParam Long softwareId, 
	                            @RequestParam String accessType, 
	                            @RequestParam String reason,
	                            Principal principal) {
	    User user = userRepository.findByUsername(principal.getName());
	    Software software = softwareRepository.findById(softwareId).orElseThrow();
	    Request request = new Request();
	    request.setUser(user);
	    request.setSoftware(software);
	    request.setAccessType(accessType);
	    request.setReason(reason);
	    requestRepository.save(request);
	    return "redirect:/employee/request";
	}

}

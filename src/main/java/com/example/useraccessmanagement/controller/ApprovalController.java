package com.example.useraccessmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.useraccessmanagement.model.Request;
import com.example.useraccessmanagement.repository.RequestRepository;

import ch.qos.logback.core.model.Model;

public class ApprovalController {
	@Autowired
	private RequestRepository requestRepository;

	@GetMapping("/manager/requests")
	public String showPendingRequests(Model model) {
	    model.addAttribute("pendingRequests", requestRepository.findByStatus("Pending"));
	    return "pendingRequests";
	}

	@PostMapping("/manager/requests/{id}")
	public String handleRequest(@PathVariable Long id, @RequestParam String action) {
	    Request request = requestRepository.findById(id).orElseThrow();
	    if ("approve".equals(action)) {
	        request.setStatus("Approved");
	    } else if ("reject".equals(action)) {
	        request.setStatus("Rejected");
	    }
	    requestRepository.save(request);
	    return "redirect:/manager/requests";
	}

}

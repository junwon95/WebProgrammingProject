package com.example.webpproject.controller;

import com.example.webpproject.Owner.Owner;
import com.example.webpproject.Owner.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
class TestController {
	private final OwnerRepository ownerRepository;

	public TestController(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@GetMapping("/hello")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/owners/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
		ModelAndView mav = new ModelAndView("ownerDetails");
		Owner owner = ownerRepository.findOwnerById(ownerId);
		mav.addObject(owner);
		return mav;
	}


}
package com.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeting.model.Greeting;
import com.greeting.service.IGreetingService;

@RestController
@RequestMapping({"/", " "})
public class GreetingController {
	@Autowired
	private IGreetingService greetingService;
	
	@GetMapping("/getGreeting")
	public ResponseEntity<Greeting> getGreeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new ResponseEntity<>(greetingService.getGreeting(name), HttpStatus.OK);
	}
	
	@PutMapping("/putGreeting")
	public ResponseEntity<Greeting> putGreeting(@RequestParam(value="name", defaultValue="Unidentified") String name) {
		return new ResponseEntity<>(greetingService.putGreeting(name), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/postGreeting")
	public ResponseEntity<Greeting> postGreeting(@RequestParam(value="name") String name) {
		return new ResponseEntity<>(greetingService.postGreeting(name), HttpStatus.CREATED);
	}
}

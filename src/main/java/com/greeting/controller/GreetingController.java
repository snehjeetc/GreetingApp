package com.greeting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/greeting")
	public ResponseEntity<List<Greeting>> getGreetings() {
		return new ResponseEntity<>(greetingService.getGreetings(), HttpStatus.OK);
	}
	
	@GetMapping("/greeting/{id}")
	public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id ){
		return new ResponseEntity<>(greetingService.getGreetingById(id), HttpStatus.OK);
	}
	
	@PutMapping("/greeting/{id}")
	public ResponseEntity<Greeting> putGreeting(@RequestParam(value="message", defaultValue="Not provided") String message, 
			@PathVariable Long id) {
		return new ResponseEntity<>(greetingService.putGreeting(message, id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/greeting")
	public ResponseEntity<Greeting> postGreeting(@RequestParam(value="firstName") Optional<String> firstName, 
			@RequestParam(value="lastName") Optional<String> lastName) {
		String name = "";
		if(firstName.isPresent())
			name += firstName.get();
		if(lastName.isPresent())
			name += " " + lastName.get();
		if(name.length() == 0)
			name = "Hello World";
		return new ResponseEntity<>(greetingService.postGreeting(name), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/greeting/{id}")
	public ResponseEntity<Greeting> deleteGreeting(@PathVariable Long id){
		return new ResponseEntity<>(greetingService.deleteGreeting(id), HttpStatus.ACCEPTED);
	}
}

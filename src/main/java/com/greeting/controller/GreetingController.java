package com.greeting.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeting.model.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	
	@GetMapping("/getGreeting")
	public Greeting getGreeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PutMapping("/putGreeting")
	public Greeting putGreeting(@RequestParam(value="name", defaultValue="Unidentified") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/postGreeting")
	public Greeting postGreeting(@RequestParam(value="name") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}

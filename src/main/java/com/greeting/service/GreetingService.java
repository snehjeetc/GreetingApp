package com.greeting.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.greeting.model.Greeting;

@Service
public class GreetingService implements IGreetingService{
	private AtomicLong counter = new AtomicLong();
	private String template = "Hello, %s!";
	
	@Override
	public Greeting getGreeting(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@Override
	public Greeting putGreeting(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template,  name));
	}

	@Override
	public Greeting postGreeting(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}

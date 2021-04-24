package com.greeting.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeting.model.Greeting;
import com.greeting.repository.IGreetingRepository;

@Service
public class GreetingService implements IGreetingService{
	private AtomicLong counter = new AtomicLong();
	private String template = "Hello, %s!";
	
	@Autowired
	private IGreetingRepository greetingRepository;
	
	

	@Override
	public Greeting putGreeting(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template,  name));
	}

	@Override
	public Greeting postGreeting(String name) {
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		return greetingRepository.save(greeting);
	}

	@Override
	public List<Greeting> getGreetings() {
		return greetingRepository.findAll();
	}

}

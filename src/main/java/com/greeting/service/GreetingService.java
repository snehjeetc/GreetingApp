package com.greeting.service;

import java.util.List;
import java.util.Optional;
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
	public Greeting putGreeting(String greetingMessage, Long id) {
		Optional<Greeting> greeting = greetingRepository.findById(id);
		greeting.get().setGreetingMessage(greetingMessage);
		return greetingRepository.save(greeting.get());
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

	@Override
	public Greeting getGreetingById(Long id) {
		return greetingRepository.findById(id).get();
	}

	@Override
	public Greeting deleteGreeting(Long id) {
		Greeting greeting = this.getGreetingById(id);
		greetingRepository.deleteById(id);
		return greeting;
	}

}

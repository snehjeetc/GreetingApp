package com.greeting.service;

import java.util.List;

import com.greeting.model.Greeting;

public interface IGreetingService {
	List<Greeting> getGreetings();
	Greeting getGreetingById(Long id);
	Greeting putGreeting(String greetingMessage, Long id);
	Greeting postGreeting(String name);
	Greeting deleteGreeting(Long id);
}

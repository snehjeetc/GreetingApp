package com.greeting.service;

import java.util.List;

import com.greeting.model.Greeting;

public interface IGreetingService {
	List<Greeting> getGreetings();
	Greeting putGreeting(String name);
	Greeting postGreeting(String name);
}

package com.greeting.service;

import com.greeting.model.Greeting;

public interface IGreetingService {
	Greeting getGreeting(String name);
	Greeting putGreeting(String name);
	Greeting postGreeting(String name);
}

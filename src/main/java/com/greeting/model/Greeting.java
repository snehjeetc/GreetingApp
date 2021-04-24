package com.greeting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String greetingMessage;
	
	public Greeting() {}
	
	public Greeting(Long id, String greetingMessage) {
		this.id = id;
		this.greetingMessage = greetingMessage;
	}
	
	public String getGreetingMessage() { return this.greetingMessage; }
	public Long getId() { return this.id; }
	
	public void setGreetingMessage(String message) { this.greetingMessage = message; }
	public void setId(Long id) { this.id = id; }
	
}

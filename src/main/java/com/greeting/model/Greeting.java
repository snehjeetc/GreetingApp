package com.greeting.model;

public class Greeting {
	private Long id;
	private String greetingMessage;
	
	public Greeting(Long id, String greetingMessage) {
		this.id = id;
		this.greetingMessage = greetingMessage;
	}
	
	public String getGreetingMessage() { return this.greetingMessage; }
	public Long getId() { return this.id; }
	
	public void setGreetingMessage(String message) { this.greetingMessage = message; }
	public void setId(Long id) { this.id = id; }
	
}

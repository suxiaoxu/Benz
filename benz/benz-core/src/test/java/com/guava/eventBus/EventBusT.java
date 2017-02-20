package com.guava.eventBus;

import java.util.Date;

import org.junit.Test;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusT {
	
	@Test
	public void test(){
		EventBus eventBus = new EventBus("test");
		EventListener el = new EventListener();
		eventBus.register(el);
		eventBus.post(new Message("zhangsan",10));
		eventBus.post(new Message("lisi",23));
		eventBus.post(new Date());
	}
}

class EventListener{
	@Subscribe
	public void listen(Message message){
		System.out.println("name = " + message.getName() +" age = "+message.getAge());
	}
	
	@Subscribe
	public void listenLn(Date date){
		System.out.println("Date = " + date);
	}
}

class Message{
	
	Message(String name,int age){
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

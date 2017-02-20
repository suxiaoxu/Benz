package com.sxx.thread.threadlocal;

public class ThreadLocalTest1 {

	static ThreadLocal studentLocal = new ThreadLocal();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		studentLocal.set(1);
		print();

	}
	
	public static void print(){
		System.out.println(studentLocal.get());
	}

}

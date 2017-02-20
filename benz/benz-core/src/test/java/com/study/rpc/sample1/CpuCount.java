package com.study.rpc.sample1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


public class CpuCount {

	private static ObjectInputStream input;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		File file = new File("D:\\1.txt");
		//ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
		Objct01 objct01 = new Objct01();
		objct01.setA(1);objct01.setB("sanshi1");
		output.writeObject(objct01);
		Objct01 objct02 = new Objct01();
		objct02.setA(2);objct02.setB("sanshi2");
		output.writeObject(objct02);
		Objct01 objct03 = new Objct01();
		objct03.setA(3);objct03.setB("sanshi3");
		output.writeObject(objct03);
		output.close();
		input = new ObjectInputStream(new FileInputStream(file));
		Objct01 object = (Objct01)input.readObject();
		System.out.println(object.getB());
		Objct01 object1 = (Objct01)input.readObject();
		System.out.println(object1.getB());
		Objct01 object2 = (Objct01)input.readObject();
		System.out.println(object2.getB());
		
	}

}

class Objct01 implements Serializable{
	private static final long serialVersionUID = 1L;
	private int a;
	private String b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	
	
}
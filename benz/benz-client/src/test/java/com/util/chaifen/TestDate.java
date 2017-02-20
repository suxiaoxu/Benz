package com.util.chaifen;

import java.util.Date;

public class TestDate {

	private static String empty = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		//System.out.println("hour="+date.getHours()+"min="+date.getMinutes()+"sec="+date.getSeconds());
		//long time = Long.parseLong("123123");
		String sn = date.getHours()+empty +date.getMinutes() +empty +date.getSeconds()+empty+(12345687888l%100000);
		Tnl sn1 = new Tnl();
		sn1.setA(12);
		print(sn1);
		System.out.println(sn1.getA());
		System.out.println(sn);
	}
	public static void print(Tnl sn){
		sn.setA(30);
	}

}
class Tnl{
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
}
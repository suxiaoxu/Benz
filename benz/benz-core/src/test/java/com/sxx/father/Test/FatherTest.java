package com.sxx.father.Test;

class Tn{
	public void print1(){
		System.out.println("123");
	}
	
	public void Print2(){
		System.out.println("222");
	}
}
class Zn extends Tn{
	public void print3(){
		System.out.println("333");
		Print2();
	}
}

class Ln extends Zn{
	@Override
	public void Print2(){
		System.out.println(444);
	}
}

public class FatherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ln sn = new Ln();
		sn.print3();

	}

}

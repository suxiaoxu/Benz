package com.util.date;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			Sn sn = new Sn();
			sn.print(2);
		}
		
	}

}

class Sn{
	public void print(int a){
		Tn tn = new Tn();
		try {
			tn.print(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Tn{
	public void print(int a) throws InterruptedException{
		Thread.sleep(1000);
		System.out.println("this is run"+a);
	}
}


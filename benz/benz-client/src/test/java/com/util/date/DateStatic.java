package com.util.date;

import java.util.Date;

public class DateStatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Date date2 = date;
		if(date.after(date2)){
			System.out.println("23432");
		}else{
			System.out.println("234324");
		}

	}

}

package com.sxx.classlorder.study;

import java.net.URL;

public class BootstrapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for(URL url:urls){
			System.out.println(url);
		}
		
		
	}

}

package com.sxx.io.file;

import java.io.File;
import java.io.IOException;

public class FileStudyTest {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\repo");
		//file.createNewFile();创建文件
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		System.out.println(file.getParentFile());
		System.out.println(file.getName());
		System.out.println(file.getFreeSpace());
		System.out.println(file.getTotalSpace());
		System.out.println(file.getPath());
		System.out.println(file.toURI());
		print(file);
	}
	
	public static void print (File file){
		File[] list = file.listFiles();
		for(File sn:list){
			if(sn.isFile()){
				System.out.println(sn.getAbsolutePath());
			}else if(sn.isDirectory()){
				print(sn);
			}
		}
	}

}

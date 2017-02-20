package com.util.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadText {

	public static void main(String[] args) throws IOException {
		List<String> list = new ArrayList<String>();
		FileReader fr = new FileReader("D:/workspace/study/Benz/benz/benz-client/src/test/java/com/util/string/ceshi1.txt");// 获取文件流
		BufferedReader br = new BufferedReader(fr); // 将流整体读取。
		String str;
		while ((str = br.readLine()) != null) {// 判断是否是最后一行
			if(str.split("15:02").length <= 1){
				String sn[] = str.split("15:01 ");
				list.add(sn[1]);
			}else{
				String sn[] = str.split("15:02 ");
				list.add(sn[1]);
			}
		}
	
		List<String> list1 = new ArrayList<String>();
		FileReader fr1 = new FileReader("D:/workspace/study/Benz/benz/benz-client/src/test/java/com/util/string/ceshi2.txt");// 获取文件流
		BufferedReader br1 = new BufferedReader(fr1); // 将流整体读取。
		String str1;
		while ((str1 = br1.readLine()) != null) {// 判断是否是最后一行
			if(str1.split("19:38").length <= 1){
				if(str1.split("19:37").length == 2){
					String sn[] = str1.split("19:37 ");
					list1.add(sn[1]);
				}else if(str1.split("20:47").length == 2){
					String sn[] = str1.split("20:47 ");
					list1.add(sn[1]);
				}else if(str1.split("20:48").length == 2){
					String sn[] = str1.split("20:48 ");
					list1.add(sn[1]);
				}
			}else{
				String sn[] = str1.split("19:38 ");
				list1.add(sn[1]);
			}
		}
		/*for(int i = 0 ; i < list1.size() ;i++){
			for(int j = 0 ; j <list.size() ;j++){
				if(list1.get(i).equals(list.get(j))){
					break;
				}else{
					if(j == list.size()-1){
						System.out.println(list1.get(i));
					}
				}
			}
		}*/
		for(int i = 0 ; i < list.size() ;i++){
			for(int j = 0 ; j <list1.size() ;j++){
				if(list.get(i).equals(list1.get(j))){
					break;
				}else{
					if(list.get(i).substring(0, 5).equals(list1.get(j).substring(0, 5))){
						System.out.println(list.get(i));
						break;
					}
				}
			}
		}

	}

}

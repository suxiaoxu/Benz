package com.sxx.linkList;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkListTest {

	public static void main(String[] args) throws InterruptedException {

		/*LinkedList<Long> linkList = new LinkedList<Long>();
		linkList.add(1000L);
		linkList.add(1001L);
		linkList.add(1002L);
		linkList.add(1003L);
		linkList.add(1004L);
		linkList.add(1005L);
		System.out.println(linkList.getFirst());
		System.out.println(linkList.size());
		System.out.println(linkList.removeFirst());
		System.out.println(linkList.size());
		linkList.add(1006L);
		System.out.println(linkList.getFirst());
		System.out.println(linkList.size());*/
		
		/*Date date1 = new Date();
		System.out.println(date1.getTime());
		Thread.sleep(1000);
		Date date2 = new Date();
		System.out.println(date2.getTime());*/
		
		Map<Long,Long> maps = new HashMap<Long,Long>();
		System.out.println(maps.get(123) == null ? 0 : maps.get(123));
	}

}

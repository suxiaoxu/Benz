package com.util.chaifen;

import java.util.List;

import com.google.common.collect.Lists;

public class SqlitChaifen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 200000;
		int count = sum % 50 == 0 ? sum/50:(sum/50)+1;
		System.out.println("count = "+count);
		List<TN> list = Lists.newArrayList();
		for(int i = 0 ; i <= count/5;i++){
			int start = i*5;
			int end = (i+1)*5-1;
			if(end > count){
				end = count;
			}
			TN tn = new TN();
			tn.setStart(start);
			tn.setEnd(end);
			list.add(tn);
		}
		System.out.println(list.size());
		for(int i =0 ;i < list.size() ;i++){
			System.out.println(list.get(i).getStart()+"===="+list.get(i).getEnd());
		}
		

	}

}
class TN{
	private int start;
	private int end;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}

package com.springinaction.springidol;

public enum TypeEnum {
	MSG(1,"shou shoutao"),PHONE(2,"phone");
	private int num;
	private String name;
	
	TypeEnum(int num, String name){
		this.num = num;
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

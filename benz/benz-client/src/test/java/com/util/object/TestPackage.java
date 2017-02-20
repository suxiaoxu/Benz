package com.util.object;

public class TestPackage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TN tn = new TN();
		System.out.println(tn.getAge());
		System.out.println(tn.getSex());

	}

}

class TN{
	private Long age;
	private Integer sex;
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	
}

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
			System.out.println("testa22");
			System.out.println("testa1sdf2");
			System.out.println("ceshi weenti");
			System.out.println("ceshi wenti");
		}
		
	}

}

/** 
* @ClassName: Sn 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xiaoxu.sxx 
* @date 2016年8月1日 下午9:19:02 
* 
*/
class Sn{
	/**
	 * @param a
	 */
	/** 
	* @Title: print 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param a    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public void print(int a){
		Tn tn = new Tn();
		try {
			tn.print(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** 
	* @Title: Sn 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return TODO    返回类型 
	* @throws 
	*/
	public static void mian()
	{
		
	}
	
	/** 
	* @Title: getName 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param a leixing1
	* @param b leixing2
	* @return int    返回类型 
	* @throws 
	*/
	public int getName(int a,String b){
		return 1;
	}
	
	/** 
	* @Title: sub 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param a
	* @param @param b
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/
	private int sub(int a,int b){
		int c = a-b;
		return c;
	}
	
	/** 
	* @Title: test =this  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param a
	* @param @param b
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/
	public int snn(int a,String b){
		return a;
	}
}

class Tn{
	public void print(int a) throws InterruptedException{
		Thread.sleep(1000);
		System.out.println("this is run"+a);
	}
}


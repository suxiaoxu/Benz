package com.sxx.thread.threadlocal;


class Tntest1{
	public static ThreadLocal<Integer> dataSourceKeyValue = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return null;
		}
	};
	
	public static void setThreadLocalValue(int i){
		dataSourceKeyValue.set(i);
	}
}


public class ThradLocalTest2 {

	public static void main(String[] args) {
		new Thread() {  
            public void run() {  
            	for(int i = 100 ;i < 109 ;i++){
            		Tntest1.setThreadLocalValue(i+1);
            		
            		try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		System.out.println("thread 1 = " + Tntest1.dataSourceKeyValue.get());
            	}
            };  
        }.start();
        new Thread() {  
            public void run() {  
            	for(int i = 200 ;i < 209 ;i++){
            		Tntest1.setThreadLocalValue(i);
            		try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		System.out.println("thread 2 = " + Tntest1.dataSourceKeyValue.get());
            	}
            };  
        }.start();
        new Thread() {  
            public void run() {  
            	for(int i = 300 ;i < 309 ;i++){
            		Tntest1.setThreadLocalValue(i);
            		try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		System.out.println("thread 3 = " + Tntest1.dataSourceKeyValue.get());
            	}
            };  
        }.start();

	}

}

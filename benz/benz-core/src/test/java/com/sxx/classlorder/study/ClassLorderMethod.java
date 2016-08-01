package com.sxx.classlorder.study;

/**
 * @author xiaoxu.sxx
 *
 *
 *	//当前线程类获取的类加载器是AppClassLoader
		sun.misc.Launcher$AppClassLoader@6b97fd
//System类为根装载器加载，java中访问不到，所以为null
null
//本类的类加载器当然也是AppClassLoader
sun.misc.Launcher$AppClassLoader@6b97fd
sun.misc.Launcher$ExtClassLoader@1c78e57
null
 */
public class ClassLorderMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 获取当前线程的类装载器
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		// 获取System类的类装载器
		ClassLoader loader1 = System.class.getClassLoader();
		// 获取本类TestClassLoader的类装载器loader2
		ClassLoader loader2 = ClassLorderMethod.class.getClassLoader();
		// 获取loader2的父类
		ClassLoader loader3 = loader2.getParent();
		// 获取loader2的父类的父类
		ClassLoader loader4 = loader3.getParent();
		System.out.println(loader);
		System.out.println(loader1);
		System.out.println(loader2);
		System.out.println(loader3);
		System.out.println(loader4);

	}

}

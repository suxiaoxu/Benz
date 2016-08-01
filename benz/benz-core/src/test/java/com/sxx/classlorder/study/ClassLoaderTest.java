package com.sxx.classlorder.study;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 一、ClassLoader加载类的顺序
 *  1.调用 findLoadedClass(String) 来检查是否已经加载类。
 *  2.在父类加载器上调用 loadClass 方法。如果父类加载器为 null，则使用虚拟机的内置类加载器。
 *  3.调用 findClass(String) 方法查找类。
 * 二、实现自己的类加载器
 *  1.获取类的class文件的字节数组
 *  2.将字节数组转换为Class类的实例
 * @author lei 2011-9-1
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        //新建一个类加载器
        MyClassLoader cl = new MyClassLoader("myClassLoader");
        //加载类，得到Class对象
        Class<?> clazz = cl.loadClass("com.sxx.classlorder.study.Animal");
        System.out.println(clazz);
        Animal an = (Animal) clazz.newInstance();
        ClassLoader cl1 = Thread.currentThread().getContextClassLoader();
        Class<?> clazs = cl1.loadClass("com.sxx.classlorder.study.Animal");
        Animal an1 = (Animal) clazz.newInstance();
        Method setSampleMethod = null;
		try {
			setSampleMethod = clazz.getMethod("say");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        try {
			setSampleMethod.invoke(an, an1);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        if(clazz == clazs){
        	System.out.println("234234234");
        }
        //得到类的实例
        Animal animal=(Animal) clazz.newInstance();
        System.out.println();
        System.out.println(Thread.currentThread().getContextClassLoader());
        animal.say();
    }
}
class Animal{
    public void say(){
        System.out.println("hello world!");
    }
}
class MyClassLoader extends ClassLoader {
    //类加载器的名称
    private String name;
    //类存放的路径
    //D:\\workspace\\gitspring\\benz\\benz\\benz-core\\src\\test\\java\\com\\sxx\\classlorder\\study\\
    private String path = "D:\\workspace\\gitspring\\benz\\benz\\benz-core\\src\\";
    MyClassLoader(String name) {
        this.name = name;
    }
    MyClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }
    /**
     * 重写findClass方法
     */
    @Override
    public Class<?> findClass(String name) {
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }
    public byte[] loadClassData(String name) {
        try {
            name = name.replace(".", "//");
            FileInputStream is = new FileInputStream(new File(path + name + ".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = is.read()) != -1) {
                baos.write(b);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
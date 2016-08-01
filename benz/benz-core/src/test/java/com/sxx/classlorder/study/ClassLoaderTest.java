package com.sxx.classlorder.study;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * һ��ClassLoader�������˳��
 *  1.���� findLoadedClass(String) ������Ƿ��Ѿ������ࡣ
 *  2.�ڸ���������ϵ��� loadClass ������������������Ϊ null����ʹ����������������������
 *  3.���� findClass(String) ���������ࡣ
 * ����ʵ���Լ����������
 *  1.��ȡ���class�ļ����ֽ�����
 *  2.���ֽ�����ת��ΪClass���ʵ��
 * @author lei 2011-9-1
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        //�½�һ���������
        MyClassLoader cl = new MyClassLoader("myClassLoader");
        //�����࣬�õ�Class����
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
        //�õ����ʵ��
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
    //�������������
    private String name;
    //���ŵ�·��
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
     * ��дfindClass����
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
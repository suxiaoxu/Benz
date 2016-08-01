package com.sxx.groovy.test;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;

public class GroovyFristTestMain {

	public static void main(String[] args) throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		/*Binding binding=new Binding();
		GroovyShell shell=new GroovyShell(binding);
		shell.evaluate(new File("com/sxx/groovy/test/GroovyFristTest.goovy"));*/
		ClassLoader parent = Thread.currentThread().getContextClassLoader();  
	    GroovyClassLoader loader = new GroovyClassLoader(parent);  
	    //�ҵ�ָ����groovy��  
	    Class groovyClass = loader.parseClass(new File("com/sxx/groovy/test/GroovyFristTest.goovy"));  
	    //������ʵ��������ǿ��ת��ΪGroovyObject����  
	    GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();  
	    //readEmailCodeUrl��������null ����ֵ��û��Ϊnull  
	   

	}

}

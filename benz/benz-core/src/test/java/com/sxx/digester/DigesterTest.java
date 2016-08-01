package com.sxx.digester;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;

public class DigesterTest {

	public static void main(String[] args) {
		Digester digester = DigesterLoader.createDigester(Thread.currentThread().getContextClassLoader().getResource("digester.xml"));
		digester.addFactoryCreate("beans/bean", Bean.class);
		digester.addBeanPropertySetter("beans/bean/name");
		digester.addBeanPropertySetter("beans/bean/age");
		digester.addSetNext("beans/bean", "addbean");
		
	}

}

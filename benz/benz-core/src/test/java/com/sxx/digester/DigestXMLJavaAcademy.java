package com.sxx.digester;

import java.util.Vector;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.annotations.DigesterLoader;

public class DigestXMLJavaAcademy {
	public void digest() {
		try {
			// Create Digester using rules defined in academyRules.xml
			/*Digester digester = DigesterLoader.createDigester(this.getClass().getClassLoader().getResource("academyRules.xml"));

			// Parse academy.xml using the Digester to get an instance of
			// Academy
			Academy a = (Academy) digester.parse(this.getClass()
					.getClassLoader().getResourceAsStream("academy.xml"));

			Vector vStud = a.getStudents();
			Vector vTeach = a.getTeachers();

			for (int i = 0; i < vStud.size(); i++) {
				System.out.println("Student>> "
						+ PropertyUtils.describe(vStud.get(i)));
			}

			for (int i = 0; i < vTeach.size(); i++) {
				System.out.println("Teacher>> "
						+ PropertyUtils.describe(vTeach.get(i)));
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DigestXMLJavaAcademy xmlDigest = new DigestXMLJavaAcademy();
		xmlDigest.digest();
	}
}

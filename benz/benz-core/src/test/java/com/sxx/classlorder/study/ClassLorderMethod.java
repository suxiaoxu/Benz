package com.sxx.classlorder.study;

/**
 * @author xiaoxu.sxx
 *
 *
 *	//��ǰ�߳����ȡ�����������AppClassLoader
		sun.misc.Launcher$AppClassLoader@6b97fd
//System��Ϊ��װ�������أ�java�з��ʲ���������Ϊnull
null
//��������������ȻҲ��AppClassLoader
sun.misc.Launcher$AppClassLoader@6b97fd
sun.misc.Launcher$ExtClassLoader@1c78e57
null
 */
public class ClassLorderMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��ȡ��ǰ�̵߳���װ����
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		// ��ȡSystem�����װ����
		ClassLoader loader1 = System.class.getClassLoader();
		// ��ȡ����TestClassLoader����װ����loader2
		ClassLoader loader2 = ClassLorderMethod.class.getClassLoader();
		// ��ȡloader2�ĸ���
		ClassLoader loader3 = loader2.getParent();
		// ��ȡloader2�ĸ���ĸ���
		ClassLoader loader4 = loader3.getParent();
		System.out.println(loader);
		System.out.println(loader1);
		System.out.println(loader2);
		System.out.println(loader3);
		System.out.println(loader4);

	}

}

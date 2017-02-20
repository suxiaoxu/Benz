package com.guava.ordering;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class OrderBaseTest {

	@Test
	public void testStaticOrdering() {
		List<String> list = Lists.newArrayList();
		list.add("peida");
		list.add("jerry");
		list.add("harry");
		list.add("eva");
		list.add("jhon");
		list.add("neron");

		System.out.println("list:" + list);
		//natural()��ʹ��Comparable���͵���Ȼ˳�� ���磺������С�����ַ����ǰ��ֵ�˳��;
		Ordering<String> naturalOrdering = Ordering.natural();
		//usingToString() ��ʹ��toString()���ص��ַ������ֵ�˳���������
		Ordering<Object> usingToStringOrdering = Ordering.usingToString();
		//arbitrary() ������һ�����ж��������˳�� ��compare(a, b) == 0 ���� a == b (identity equality)��
		//�����������û���κκ��壬 ������VM������������һ��������
		Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

		System.out.println("naturalOrdering:"
				+ naturalOrdering.sortedCopy(list));
		System.out.println("usingToStringOrdering:"
				+ usingToStringOrdering.sortedCopy(list));
		System.out.println("arbitraryOrdering:"
				+ arbitraryOrdering.sortedCopy(list));
	}
}

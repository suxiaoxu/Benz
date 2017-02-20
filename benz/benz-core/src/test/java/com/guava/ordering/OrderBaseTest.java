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
		//natural()：使用Comparable类型的自然顺序， 例如：整数从小到大，字符串是按字典顺序;
		Ordering<String> naturalOrdering = Ordering.natural();
		//usingToString() ：使用toString()返回的字符串按字典顺序进行排序；
		Ordering<Object> usingToStringOrdering = Ordering.usingToString();
		//arbitrary() ：返回一个所有对象的任意顺序， 即compare(a, b) == 0 就是 a == b (identity equality)。
		//本身的排序是没有任何含义， 但是在VM的生命周期是一个常量。
		Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

		System.out.println("naturalOrdering:"
				+ naturalOrdering.sortedCopy(list));
		System.out.println("usingToStringOrdering:"
				+ usingToStringOrdering.sortedCopy(list));
		System.out.println("arbitraryOrdering:"
				+ arbitraryOrdering.sortedCopy(list));
	}
}

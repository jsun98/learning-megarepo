package com.josh.java.leetcode;

import java.util.*;

/**
 * This class contains demonstrations of some commonly used methods/tools/tricks
 * that may be helpful when doing leetcode
 */
public class CommonUtilMethods {
	public static void main (String[] args) {
		// sort an array
		int[] a1 = {3, 2, 1, 0};
		Arrays.sort(a1); // 0, 1, 2, 3

		// sort a collection and Arrays.asList
		List<Integer> list1 = Arrays.asList(4, 3, 2, 1);
		Collections.sort(list1); // 1, 2, 3, 4

		// List.addAll
		List<Integer> list2 = new ArrayList<>();
		list2.addAll(list1); // 1, 2, 3, 4

		// queue
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.poll(); // returns 1
		
	}
}

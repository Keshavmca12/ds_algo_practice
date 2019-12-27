package com.hackerrank;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Autor : Keshav Kumar
 * @Date : 28-May-2019
 */

public class Solution {

	// Complete the compareTriplets function below.
	// Complete the plusMinus function below.
	static void plusMinus() {
		int[] arr = { -4, 3, -9, 0, 4, 1 };
		int plus = 0, minus = 0, zero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				++minus;
			} else if (arr[i] > 0) {
				++plus;
			} else {
				++zero;
			}
		}
		if (plus > 0) {
			System.out.println(BigDecimal.valueOf(plus / arr.length).setScale(6));
		} else {
			System.out.println(BigDecimal.valueOf(0).setScale(6, BigDecimal.ROUND_HALF_UP));
		}
		if (minus > 0) {
			double d = minus / new Double(arr.length);
			System.out.println(BigDecimal.valueOf(d).setScale(6, BigDecimal.ROUND_HALF_UP));
		} else {
			System.out.println(BigDecimal.valueOf(0).setScale(6, BigDecimal.ROUND_HALF_UP));
		}
		if (zero > 0) {
			System.out.println(BigDecimal.valueOf(zero / arr.length).setScale(6, BigDecimal.ROUND_HALF_UP));
		} else {
			System.out.println(BigDecimal.valueOf(0).setScale(6, BigDecimal.ROUND_HALF_UP));
		}
	}

	static String timeConversion(String s) {

		String result = s.substring(0, s.length() - 2);
		if (s.substring(s.length() - 2).equals("PM")) {
			String[] arr = result.split(":");
			if (!arr[0].equals("12")) {
				int num = Integer.parseInt(arr[0]) + 12;
				result = result.replaceFirst(arr[0], String.valueOf(num));
			}
		} else if (s.substring(s.length() - 2).equals("AM")) {
			String[] arr = result.split(":");
			if (arr[0].equals("12")) {
				result = result.replaceFirst(arr[0], "00");
			}
		}

		return result;

	}

	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int[] result = new int[queries.length];
		for (int i = 0; i < k; i++) {
			int temp = a[a.length - 1];
			for (int j = a.length - 1; j > 0; j--) {
				a[j] = a[j - 1];
			}
			a[0] = temp;
		}
		for (int i = 0; i < queries.length; i++) {
			result[i] = a[queries[i]];
		}
		return result;
	}

	static void extraLongFactorials(int n) {
		BigInteger result = BigInteger.valueOf(n);
		for (int i = n - 1; i > 1; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		System.out.println(result);
	}

	public static int nonDivisibleSubset(int k, List<Integer> s) {
		Set<Integer> resultSet = new HashSet<>();
		Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.size() - 1; i++) {
            for (int j = i+1; j < s.size(); j++) {
            	 System.out.println("j : "+ s.get(i)+ "   j+1  " +s.get(j));
            	int sum  = s.get(i)+ s.get(j);
            	System.out.println("sum "+ sum + " sum%k "+ sum  % k);
                if((sum  % k) == 0){
                    	map.put(s.get(i), true);
                    	map.put(s.get(j), true);
                }
                System.out.println(resultSet);
            }
        }
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
			if(entry.getValue() == null){
				resultSet.add(entry.getKey());
			}
		}
        return resultSet.size();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * int n = scanner.nextInt();
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * int[] arr = new int[n];
		 * 
		 * String[] arrItems = scanner.nextLine().split(" ");
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * for (int i = 0; i < n; i++) { int arrItem =
		 * Integer.parseInt(arrItems[i]); arr[i] = arrItem; }
		 */

		// plusMinus();

		// scanner.close();

		// System.out.println(Solution.timeConversion("12:05:45AM"));
		int[] arr = { 1, 2, 3 };
		int[] arr1 = { 0, 1, 2 };
		List<Integer> list =new ArrayList<Integer>();
		list.add(1);
		list.add(7);
		list.add(2);
		list.add(4);
		nonDivisibleSubset(3, list);
		//extraLongFactorials(25);
		// System.out.println(Arrays.toString(Solution.circularArrayRotation(arr,
		// 2, arr1)));
	}
}

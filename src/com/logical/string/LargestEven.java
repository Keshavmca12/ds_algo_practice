package com.logical.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestEven {
	public static void main(String[] args) {
		System.out.println("Enter no of test cases : ");
		Scanner sc = new Scanner(System.in);
		int testCaseCount = sc.nextInt();
		List<String> testCases = new ArrayList<>();
		List<String> outputList = new ArrayList<>();

		for (int i = 0; i < testCaseCount; i++) {
			testCases.add(sc.next());
		}
		sc.close();
		for (String string : testCases) {
			outputList.add(convertLargestEvenInteger(string));
		}
		System.out.println(outputList);
	}

	private static String convertLargestEvenInteger(String inputStr) {
		int lastDigit = Integer.parseInt(Character.toString(inputStr.charAt(inputStr.length() - 1)));
		for (int i = 0; i < inputStr.length(); i++) {
			int digit = Integer.parseInt(Character.toString(inputStr.charAt(i)));
			if ((digit % 2 == 0) && digit < lastDigit) {
				inputStr.substring(0, i - 1).concat(Integer.toString(lastDigit))
						.concat(inputStr.substring(i + 1, inputStr.length() - 2)).concat(Integer.toString(digit));
			}
		}
		return inputStr;
	}
}

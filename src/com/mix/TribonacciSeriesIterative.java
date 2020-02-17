package com.mix;

import java.util.Scanner;

/**
 * @Autor : Keshav Kumar
 * @Date : 17-Feb-2020
 */

public class TribonacciSeriesIterative {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		int number = 15;// sc.nextInt();
		for (int i = 1; i <= number; i++) {
			System.out.println(tribonacci(i));
		}
		// sc.close();
	}

	public static int tribonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}

		return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
	}
}

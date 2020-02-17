package com.mix;

import java.util.Scanner;

/**
 * @Autor : Keshav Kumar
 * @Date : 17-Feb-2020
 */

public class TribonacciSeriesRecursive {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		int n1 = 1, n2 = 1, n3 = 2;
		int number = 15;// sc.nextInt();
		for (int i = 1; i <= number; i++) {
			if (i == 1 || i == 2) {
				System.out.println(n1);
			} else if (i == 3) {
				System.out.println(n3);
			} else {
				int temp = n1 + n2 + n3;
				System.out.println(temp);
				n1 = n2;
				n2 = n3;
				n3 = temp;
			}

		}
		// sc.close();
	}

}

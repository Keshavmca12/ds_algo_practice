package com.hackerrank;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Autor : Keshav Kumar
 * @Date : 31-Oct-2019
 */

public class MinimumPasswordCount {
	static int minimumNumber(int n, String password) {
		// Return the minimum number of characters to make the password strong
		int count = 0;
		if (n == 0) {
			return 6;
		}
		char[] charArray = password.toCharArray();
		boolean small = false, capital = false, digit = false, special = false;
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isUpperCase(charArray[i])) {
				capital = true;
			}
			if (Character.isLowerCase(charArray[i])) {
				small = true;
			}
			if (Character.isDigit(charArray[i])) {
				digit = true;
			}
			if (isspecialCharacter(charArray[i])) {
				special = true;
			}
		}
		if (!capital) {
			count++;
		}
		if (!small) {
			count++;
		}
		if (!digit) {
			count++;
		}
		if (!special) {
			count++;
		}

		if ((count + password.length()) < 6) {
			count += (6 - (count + password.length()));
		}

		return count;
	}

	private static boolean isspecialCharacter(char ch) {
		String str = "!@#$%^&*()-+";
		return str.indexOf(String.valueOf(ch)) > -1 ? true : false;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter bufferedWriter = new BufferedWriter(new
		 * FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int n = scanner.nextInt();
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * String password = scanner.nextLine();
		 */
		String password = "#Ab1";

		int answer = minimumNumber(password.length(), password);

		System.out.println("count  : " + answer);

		/*
		 * bufferedWriter.write(String.valueOf(answer));
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
	}
}

package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Autor : Keshav Kumar
 * @Date : 31-Oct-2019
 */

public class CamelCaseWordCount {
	// Complete the camelcase function below.
	static int camelcase(String s) {
		if(s.length() == 0){
			return 0;
		}
		int count = 1;
		char charArray[] = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isUpperCase(charArray[i])) {
				count++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String s = "";
		 int result = camelcase(s);
		 System.out.println(result);
		 /*
		 * 
		 * bufferedWriter.write(String.valueOf(result));
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
	}
}

package com.java;

/**
 * @Autor : Keshav Kumar
 * @Date : 03-Jul-2019
 */

public class ConvertCamelCase {

	public static void main(String[] args) {
		String data = "CREATE_REMINDER";
		System.out.println(ConvertCamelCase.convert(data));
	}

	private static String convert(String data) {
		boolean isPreviousCharacterUnderScore = false;
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == '_') {
				isPreviousCharacterUnderScore = true;
			} else {
				if (!isPreviousCharacterUnderScore && i != 0) {
					result = result + String.valueOf(data.charAt(i)).toLowerCase();
				} else {
						result = result.concat(String.valueOf(data.charAt(i)));
						isPreviousCharacterUnderScore = false;
				}
			}
		}
		return result;

	}

}

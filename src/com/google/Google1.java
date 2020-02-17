package com.google;

public class Google1 {

	
	public static void main(String[] args) {
		String test = "vmxibkgrlm";
		System.out.println(solution(test));
	}
	
	public static String solution(String x) {
		StringBuilder stringBuilder= new StringBuilder();
		if(x == null || x == "") {
			return "";
		}
		for (int i = 0; i < x.length(); i++) {
			Character ch = x.charAt(i);
			if(Character.isLowerCase(ch)) {
				int ascii = ch;
				stringBuilder.append(Character.toString((char)(219-ascii)));
			}else {
			stringBuilder.append(String.valueOf(ch));
			}
		}
		return stringBuilder.toString();
	}
}

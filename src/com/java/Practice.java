package com.java;

/**
 * @Autor : Keshav Kumar 
 * @Date : 06-Jan-2020
 */

public class Practice {

	public static void main(String[] args) {
		String str = "a,b&c";
		int i=0; 
		int j = str.length()-1;
		char[] strArray = str.toCharArray();
		while(i< j){
	//		Arrays.asList(strArray).contains(str);
			if(!Character.isAlphabetic(strArray[i]) && !Character.isAlphabetic(strArray[j])){
				i++;
				j--;
			}else if(!Character.isAlphabetic(strArray[i])){
				i++;
			}else if(!Character.isAlphabetic(strArray[j])){
				j--;
			}else{
				char temp = strArray[i];
				strArray[i] = strArray[j];
				strArray[j] = temp;
				i++;
				j--;
			}
		}
		for (int k = 0; k < strArray.length; k++) {
			System.out.print(strArray[k]);
		}
	}
	
}



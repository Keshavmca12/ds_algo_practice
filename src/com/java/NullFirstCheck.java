package com.java;

/**
 * @Autor : Keshav Kumar
 * @Date : 06-Dec-2018
 */

public class NullFirstCheck {
	public static void main(String[] args) throws CloneNotSupportedException {
		Integer  x= null;
		
		if(null == x){
			System.out.println(x);
		}
		
		if(x == null){
			System.out.println(x);
		}
		
		NumberToWord numberToWord = new NumberToWord();
		System.out.println(numberToWord);
		
		NumberToWord numberToWordClone = (NumberToWord) numberToWord.clone();
		System.out.println(numberToWord);
	}
	
}

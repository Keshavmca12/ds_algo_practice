package com.java;

/**
 * @Autor : Keshav Kumar
 * @Date : 06-Dec-2018
 */

public class NullFirstCheck {
	public static void main(String[] args) {
		Integer  x= null;
		
		if(null == x){
			System.out.println(x);
		}
		
		if(x == null){
			System.out.println(x);
		}
	}
}

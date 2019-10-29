package com.test;

public class RemainderTest {
	public static void main(String[] args) {
		System.out.println(9 % 10);
		System.out.println(9 / 10);
		try {
			System.out.println("Remainder by 0 : " + 0 % 10);
		} catch (Exception e) {
			System.out.println("Remainder by 0 exception : " + e.getMessage());
		}
		
		try {
			System.out.println("Divison by 0 : " + 0 / 0);
		} catch (Exception e) {
			System.out.println("Divison by 0  exception: " + e.getMessage());
		}
		
	}
}

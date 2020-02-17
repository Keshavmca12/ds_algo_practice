package com.exception;

public class ExceptionWithInheritance {
	public static void main(String[] args) {
		A a = new B();
		a.show();
	}
}

class A {
	void show() throws  NullPointerException{
		System.out.println("A");
	}
}

class B extends A {
	void show() throws  IndexOutOfBoundsException {
		System.out.println("B");
	}
}
package com.java8;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Autor : Keshav Kumar
 * @Date : 09-Jan-2020
 */

public class FunctionReferenceExample {
	public static void main(String[] args)

	{

		System.out.println("Method reference to instance method (ClassName::MethodName)");
		// Calling toLowerCase() method using lambda

		Function<String, String> lambdaFunction = (String s) -> s.toLowerCase();
		System.out.println(lambdaFunction.apply("JAVA"));

		// Calling toLowerCase() method using method reference

		Function<String, String> referenceFunction = String::toLowerCase;
		System.out.println(referenceFunction.apply("JAVA"));

		System.out.println(" Method reference to instance method (ClassName::MethodName)");

		Function<String, String> lambdaInstanceFunction = (String s) -> s.toLowerCase();
		System.out.println(lambdaInstanceFunction.apply("JAVA"));

		// Calling toLowerCase() method using method reference

		Function<String, String> referenceInstanceFunction = String::toLowerCase;
		System.out.println(referenceInstanceFunction.apply("JAVA"));

		System.out.println("Method reference to instance method (ReferenceVariable::MethodName)");

		Company c = new Company("My_Company");

		// Calling getName() of c using lambda

		Supplier<String> lambdaSupplier = () -> c.getName();
		System.out.println(lambdaSupplier.get());

		// Calling getName() of c using method reference

		Supplier<String> referenceSupplier = c::getName;
		System.out.println(referenceSupplier.get());

		System.out.println("Constructor References");
		
		
		  Supplier<Company> lambdaConstructorSupplier = () -> new Company();
	        lambdaConstructorSupplier.get();
	         
	        //Creating objects using constructor references
	         
	        Supplier<Company> referenceContructorSupplier = Company::new;
	        referenceContructorSupplier.get();	
	}
}

class Company {
	String name;

	public Company() {
		// TODO Auto-generated constructor stub
	}
	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

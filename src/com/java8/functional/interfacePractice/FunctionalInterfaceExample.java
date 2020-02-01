package com.java8.functional.interfacePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Autor : Keshav Kumar
 * @Date : 09-Jan-2020
 */

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		List<Student> listOfStudents = new ArrayList<Student>();

		listOfStudents.add(new Student(111, "John", 81.0, "Mathematics"));

		listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));

		listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));

		listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));

		listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));

		listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));

		listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));

		listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));

		listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));

		listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));

		System.out.println("Predicate *******************");

		Predicate<Student> mathematicsPredicate = (Student student) -> student.getSpecialization()
				.equals("Mathematics");

		List<Student> mathematicsStudents = new ArrayList<Student>();

		for (Student student : listOfStudents) {
			if (mathematicsPredicate.test(student)) {
				mathematicsStudents.add(student);

			}
		}

		System.out.println(mathematicsStudents);

		System.out.println("Consumer *******************");

		Consumer<Student> percentageConsumer = (Student student) -> {
			System.out.println(student.getName() + " : " + student.getPercentage());
		};

		for (Student student : listOfStudents) {
			percentageConsumer.accept(student);
		}

		System.out.println("Function *************************");

		Function<Student, String> nameFunction = (Student Student) -> Student.getName();

		List<String> studentNames = new ArrayList<String>();

		for (Student student : listOfStudents) {
			studentNames.add(nameFunction.apply(student));
		}

		System.out.println(studentNames);

		System.out.println("***************    supplier ******************");

		Supplier<Student> studentSupplier = () -> new Student(111111, "New Student", 92.9, "Java 8");

		listOfStudents.add(studentSupplier.get());

		System.out.println(listOfStudents);

		System.out.println("Predicate *******************");

		IntPredicate intPredicate = (x) -> {
			if (x < 8)
				return true;
			return false;
		};

		System.out.println("9 is less than 8 " + intPredicate.test(544331));
	}

}

class Student {
	int id;

	String name;

	double percentage;

	String specialization;

	public Student(int id, String name, double percentage, String specialization) {
		this.id = id;

		this.name = name;

		this.percentage = percentage;

		this.specialization = specialization;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPercentage() {
		return percentage;
	}

	public String getSpecialization() {
		return specialization;
	}

	@Override
	public String toString() {
		return id + "-" + name + "-" + percentage + "-" + specialization;
	}
}

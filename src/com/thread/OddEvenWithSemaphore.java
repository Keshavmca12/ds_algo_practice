package com.thread;

import java.util.concurrent.Semaphore;

/**
 * @Autor : Keshav Kumar
 * @Date : 12-Feb-2020
 */

public class OddEvenWithSemaphore {

	public static void main(String[] args) {
		SharedPrinter sp = new SharedPrinter();

		Thread even = new Thread(new PrintEven(sp, 20), "even");
		Thread odd = new Thread(new PrintOdd(sp, 20), "odd");
		even.start();
		odd.start();

	}

}

class SharedPrinter {

	private Semaphore semEven = new Semaphore(0);
	private Semaphore semOdd = new Semaphore(1);

	public void printEven(int num) {
		try {
			semEven.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " : " + num);
		semOdd.release();
	}

	public void printOdd(int num) {
		try {
			semOdd.acquire();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " : " + num);
		semEven.release();
	}
}

class PrintEven implements Runnable {
	private SharedPrinter sp;
	private int MAX;

	public PrintEven(SharedPrinter sp, int mAX) {
		super();
		this.sp = sp;
		MAX = mAX;
	}

	@Override
	public void run() {
		for (int i = 2; i < MAX; i = i + 2) {
			sp.printEven(i);
		}

	}

}

class PrintOdd implements Runnable {
	private SharedPrinter sp;
	private int MAX;

	public PrintOdd(SharedPrinter sp, int mAX) {
		super();
		this.sp = sp;
		MAX = mAX;
	}

	@Override
	public void run() {
		for (int i = 1; i < MAX; i = i + 2) {
			sp.printOdd(i);
		}

	}

}

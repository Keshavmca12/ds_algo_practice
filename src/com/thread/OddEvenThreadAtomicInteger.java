package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

/*public class OddEvenThread {
	public static void main(String[] args) {
	}

}*/

/**
 * @Autor : Keshav Kumar
 * @Date : 31-Dec-2019
 */

public class OddEvenThreadAtomicInteger {

	public static void main(String[] args) {
		/*
		 * Runnable print = () -> { while (atomicNumber.get() < 10) {
		 * synchronized (atomicNumber) { if ((atomicNumber.get() % 2 == 0) &&
		 * "Even".equals(Thread.currentThread().getName())) {
		 * System.out.println("Even" + ":" + atomicNumber.getAndIncrement()); }
		 * else if ((atomicNumber.get() % 2 != 0) &&
		 * "Odd".equals(Thread.currentThread().getName())) {
		 * System.out.println("Odd" + ":" + atomicNumber.getAndIncrement()); } }
		 * } };
		 */

		Thread t1 = new Thread(new Print());
		t1.setName("Even");
		t1.start();
		Thread t2 = new Thread(new Print());
		t2.setName("Odd");
		t2.start();

	}

}

class Print implements Runnable {
	static AtomicInteger atomicNumber = new AtomicInteger(1);

	@Override
	public void run() {
		while (atomicNumber.get() < 10) {
			synchronized (atomicNumber) {
				if ((atomicNumber.get() % 2 == 0) && "Even".equals(Thread.currentThread().getName())) {
					System.out.println(Thread.currentThread().getName()+ ":" + atomicNumber.getAndIncrement());
				} else if ((atomicNumber.get() % 2 != 0) && "Odd".equals(Thread.currentThread().getName())) {
					System.out.println(Thread.currentThread().getName() + " :: " + atomicNumber.getAndIncrement());
				}
			}
		}
	}

}

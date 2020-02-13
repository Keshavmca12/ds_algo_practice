package com.thread;

/**
 * @Autor : Keshav Kumar
 * @Date : 12-Feb-2020
 */

public class OddEvenWithWait implements Runnable {

	final int MAX_NUMBER = 20;
	static int number = 1;
	int remainder;

	public OddEvenWithWait(int remainder) {
		this.remainder = remainder;
	}
	static final Object lock = new Object();

	@Override
	public void run() {

		while (number < MAX_NUMBER) {
			synchronized (lock) {
				if (number % 2 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(Thread.currentThread().getName() + " : " + number);
				number++;
				lock.notifyAll();
			}
		}

	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new OddEvenWithWait(1));
		t1.setName("odd");
		
		Thread t2 = new Thread(new OddEvenWithWait(0));
		t2.setName("even");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

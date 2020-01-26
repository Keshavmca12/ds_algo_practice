package com.thread;

public class OddEvenThread {
	public static void main(String[] args) {
	}

}

class PrintEvenThread extends Thread {

	private int i = 0;

	@Override
	public void run() {

		try {
			i = i + 2;
			System.out.println(i);
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class PrintOddThreads implements Runnable{

	private int i = 1;

	@Override
	public void run() {

		try {
			i = i + 2;
			System.out.println(i);
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

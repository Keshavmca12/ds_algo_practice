package com.thread;

public class ThreadJoin implements Runnable {

	@Override
	public void run() {
		System.out.println("name" + Thread.currentThread().getName());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadJoin());
		Thread t2 = new Thread(new ThreadJoin());
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(hello());

	}

	private static int hello() {
		try {
			throw new RuntimeException("dwed");
		} finally {
			return 10;
		}
	}

}

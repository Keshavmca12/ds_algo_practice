package com.thread;

/**
 * @Autor : Keshav Kumar
 * @Date : 18-Feb-2020
 */

public class OddEvenWithWaitObjectLevel {
	
	public static void main(String[] args) throws InterruptedException {
		PrintOddEven poe = new PrintOddEven(1);
		Runnable runnableEven = ()-> {
			poe.printEven();
		};
		Runnable runnableOdd = ()-> {
			poe.printOdd();
		};
		Thread evenThread = new Thread(runnableEven, Type.EVEN.name());
		Thread oddThread = new Thread(runnableOdd, Type.ODD.name());
		evenThread.start();
		oddThread.start();
		evenThread.join();
		oddThread.join();
	}

}

class PrintOddEven {
	private static final int MAX_NUMBER = 20;
	int number;

	public PrintOddEven(int number) {
		super();
		this.number = number;
	}
	
	public void printOdd(){
		while(number < MAX_NUMBER){
			synchronized(this){
				if(number % 2 == 0){
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " + number);
				number ++;
				notify();
			}
		}
	}
	
	public void printEven(){
		while(number < MAX_NUMBER){
			synchronized(this){
				if(number % 2 != 0){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " + number);
				number ++;
				notify();
			}
		}
	}


}


enum Type{
	EVEN, ODD;
}
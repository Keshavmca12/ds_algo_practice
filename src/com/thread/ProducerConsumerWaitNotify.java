package com.thread;

import java.util.LinkedList;
import java.util.List;

/**
 * @Autor : Keshav Kumar
 * @Date : 18-Feb-2020
 */

public class ProducerConsumerWaitNotify {
	public static void main(String[] args) {
		ProduceConsume produceConsume = new ProduceConsume();
		Thread producerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				produceConsume.produce();
				
			}
		}, "producer1");
		Runnable consumerRunnable = ()->{
			produceConsume.consume();
		};
		Thread consumerThread = new Thread(consumerRunnable, "consumer 1");
		/*Runnable consumerRunnable1 = ()->{
			produceConsume.consume();
		};
		Thread consumerThread1= new Thread(consumerRunnable1, "consumer 2");*/
		producerThread.start();
		consumerThread.start();
	//	consumerThread1.start();
		try {
			producerThread.join();
			consumerThread.join();
	//		consumerThread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ProduceConsume {
	int MAX_VALUE = 500;
	LinkedList<Integer> bufferList = new LinkedList<>();
	int value = 0;
	int capacity = 2;

	public void produce() {
		while (value < MAX_VALUE) {
			synchronized (this) {
				if (bufferList.size() == capacity) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Producer produced value : " + value);
				bufferList.add(value++);
				notify();
				 // and sleep 
               /* try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
			}
		}
	}

	public void consume() {
		while (value < MAX_VALUE) {
			synchronized (this) {
				if (bufferList.size() == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		//		System.out.println(bufferList);
				System.out.println("Consumer "+ Thread.currentThread().getName() + " consumed value : " + bufferList.removeFirst());

				notify();
				 // and sleep 
             /*   try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
			}
		}
	}
}

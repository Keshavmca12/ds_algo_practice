package com.executor.service;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Autor : Keshav Kumar
 * @Date : 13-Feb-2020
 */

public class ExecutorServiceWithFuture {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		FactorialCalculator fc = new FactorialCalculator(2005);
		Future<BigInteger> future = threadPool.submit(fc);

		Instant start = Instant.now();

		System.out.println("task statred");
		while (!future.isDone()) {
			System.out.println("Task is not completed yet....");
		/*	try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/ // sleep for 1 millisecond before checking again }
		}

		System.out.println("task completed");
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).toMillis());
		try {
			System.out.println("Factorial   :   " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		threadPool.shutdown();
	}

}

class FactorialCalculator implements Callable<BigInteger> {

	int number;

	public FactorialCalculator(int number) {
		this.number = number;
	}

	@Override
	public BigInteger call() {
		BigInteger result = null;
		try {
			result = factorial(number);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public BigInteger factorial(int number) throws InterruptedException {
		BigInteger result = new BigInteger("1");
		while (number > 0) {
//			Thread.sleep(1);
			result = result.multiply(new BigInteger(String.valueOf(number)));
			number--;
		}
		return result;
	}

}

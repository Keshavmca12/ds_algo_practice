package com.design.pattern;

import java.io.Serializable;

/**
 * @Autor : Keshav Kumar 
 * @Date : 03-Feb-2020
 */

public class SingletonInnerClass implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2747497155365560305L;
	
	private static SingletonInnerClass INSTANCE = null;

	private SingletonInnerClass(){
		
	}
	
	static class StaticInnerSingleton{
		private static SingletonInnerClass INSTANCE = new SingletonInnerClass();
	}
	
	public static SingletonInnerClass getInstance(){
		return StaticInnerSingleton.INSTANCE;
	}
	
	protected SingletonInnerClass readResolve() {
		return StaticInnerSingleton.INSTANCE;
	}
 
}



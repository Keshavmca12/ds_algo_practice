package com.design.pattern;

import java.io.Serializable;

/**
 * @Autor : Keshav Kumar
 * @Date : 07-Jan-2020
 */

public class SingletonClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2870410947366259937L;
	
	private static volatile SingletonClass INSTANCE = null;

	private SingletonClass() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		/*throw new CloneNotSupportedException();*/
		return INSTANCE;
	}

	public static SingletonClass getInstance() {
		if (INSTANCE == null) {
			synchronized (SingletonClass.class) {
				if (INSTANCE == null) {
					INSTANCE = new SingletonClass();
				}
			}
		}
		return INSTANCE;
	}

	protected Object readResolve() {
		return INSTANCE;
	}
}

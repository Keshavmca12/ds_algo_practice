package com.overriding.scenarios;

import java.io.FileNotFoundException;
import java.io.IOError;

/**
 * @Autor : Keshav Kumar 
 * @Date : 27-Feb-2020
 */

public class OverridingModifiers {
	public static void main(String[] args) {
		AException a = new BException();
		a.show("dsjkf");
	}

}


class AException {
	public void show(String m){
		System.out.println("show2");
	}
	
	public void showChecked(String m) throws Exception, IOError{
		System.out.println("show2");
	}
}

class BException extends AException {
	

	public void show(String m) throws RuntimeException{
		System.out.println("show11" + m);
	}
	
	/***
	 * Exception FileNotFoundException is not compatible with throws clause in 
	 AException.showChecked(String)
	 */
	
	public void showChecked(String m) throws RuntimeException, FileNotFoundException {
		System.out.println("show2");
	}
}

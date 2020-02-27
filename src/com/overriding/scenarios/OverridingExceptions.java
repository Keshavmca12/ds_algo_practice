package com.overriding.scenarios;

/**
 * @Autor : Keshav Kumar 
 * @Date : 27-Feb-2020
 */

public class OverridingExceptions {
	public static void main(String[] args) {
		AModifierScenario a = new BModifierScenario();
		a.show("dsjkf");
	}

}


class AModifierScenario {
	public void show(String m){
		System.out.println("show2");
	}
}

class BModifierScenario extends AModifierScenario {
	
	/**
	 * protected void show : Cannot reduce the visibility of the inherited method from AModifierScenario 
	 */
	public void show(String m){
		System.out.println("show11" + m);
	}
}

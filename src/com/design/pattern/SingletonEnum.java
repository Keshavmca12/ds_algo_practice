package com.design.pattern;

import java.util.Arrays;

/**
 * @Autor : Keshav Kumar
 * @Date : 03-Feb-2020
 */

public enum SingletonEnum {

	INSTANCE;
	private final String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}
}

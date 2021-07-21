package com.java.classLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClassLoader {
	public static void main(String[] args) {
		CustomClassLoader loader = new CustomClassLoader();
		Class<?> c = loader.findClass("com.java.classLoader.TestClassForLoader");
		Object ob  = null;
		try {
			ob = c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method md = null;
		try {
			md = c.getMethod("show");
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			md.invoke(ob);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ThreadrunMain {
	public void run() {
		System.out.println("run");
	}

	public static void main(String[] args) {
		System.out.println("hello");
		new ThreadrunMain().run();
		Map<String, String> map = new HashMap<>();
		map.put("1", "hello1");
		map.put("2", "hello2");
		try {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println(entry.getKey());
				map.put("3", "hello3");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		Iterator<Map.Entry<String, String>> entrySet = map.entrySet().iterator();
		while (entrySet.hasNext()) {
			Map.Entry<String, String> entry = entrySet.next();
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			map.put("3", "hello3");
		}

		System.out.println(map);
	}
}

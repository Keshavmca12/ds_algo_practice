package 	com.paypal;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Author {
	int id;
}

interface Climb {
	boolean isTooHigh(int height, int limit);
}

public class Test {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		int count = Integer.parseInt(name);
		List<Integer> inpiutList = new ArrayList<>();
		for (int i = 1; i <= count; i++) {
			if (s.hasNext()) {
				String temp = s.nextLine();
				inpiutList.add(Integer.parseInt(temp));
			}
		}
		for (Integer integer : inpiutList) {
			System.out.println(requiredNumbers(integer));
		}

	}

	public static int requiredNumbers(int n) {
		int num1 = 1, num2 = n;
		int half = n / 2;
		for (int i = 1; i <= half; i++) {
			if (n % i == 0) {
				int temp = n / i;
				if (Math.abs(temp - i) < Math.abs(num1 - num2)) {
					num1 = temp;
					num2 = i;
				}
			}
		}

		return (num1 + num2);
	}

	static void charNum(String inputString) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		char[] strArray = inputString.toCharArray();
		for (char c : strArray) {
			if (charMap.containsKey(c)) {
				charMap.put(c, charMap.get(c) + 1);
			} else {
				charMap.put(c, 1);
			}
		}
		Set<Character> charsInString = charMap.keySet();
		for (Character ch : charsInString) {
			if (charMap.get(ch) > 1) {
				System.out.println(ch + " : " + charMap.get(ch));
			}
		}
	}

	/*
	 * public static void main(String[] args) { charNum("JavaJ2Ee"); }
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 *//**
		 * Output : John Anne Bob How ??? findout
		 *//*
			 * Map<String, Integer> names = new HashMap<String, Integer>();
			 * names.put("Anne", 10); names.put("John", 35); names.put("Bob", 2);
			 * Set<Entry<String, Integer>> set = names.entrySet(); List<Entry<String,
			 * Integer>> list = new ArrayList<Entry<String, Integer>>(set);
			 * Collections.sort( list, new Comparator<Map.Entry<String, Integer>>() { public
			 * int compare( Map.Entry<String, Integer> order1, Map.Entry<String, Integer>
			 * order2) { return (order2.getValue()).compareTo( order1.getValue() ); } });
			 * for(Map.Entry<String, Integer> entry:list){
			 * System.out.print(" "+entry.getKey()); } }
			 */

	/*
	 * public static void main(String args[]) {
	 * 
	 * { ArrayList<Integer> myList = new ArrayList<>( ); myList.add(7);
	 * myList.add(4); myList.add(10); myList.add(3); myList.add(17); Stream<Integer>
	 * myStream = myList.stream();
	 * 
	 * Stream<Integer> myVals = myList.stream().sorted().filter((n) -> (n % 2) ==
	 * 1); myVals = myList.stream().filter( (n) -> (n % 2) == 1) .filter((n) -> n >
	 * 5); myVals.forEach((n) -> System.out.print(n + " ") ); } List<String>
	 * Languages = Arrays.asList("Python","Java","python"); Map<String, Integer>
	 * LanguagesLength =
	 * Languages.stream().collect(Collectors.toMap(Function.identity(),
	 * String::length));
	 * 
	 * System.out.println("list: " + Languages);
	 * 
	 * }
	 */

	/*
	 * public static void main(String a[]) { ArrayList<Double> vals = new
	 * ArrayList<>(); vals.add(1.0); vals.add(4.0); vals.add(16.0);
	 * Spliterator<Double> spltitr = vals.spliterator();
	 * while(spltitr.tryAdvance((n) -> System.out.print(" "+n)));
	 * System.out.println(); spltitr = vals.spliterator(); ArrayList<Double> sqrs =
	 * new ArrayList<>(); while(spltitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));
	 * spltitr = sqrs.spliterator(); spltitr.forEachRemaining((n) ->
	 * System.out.print(" "+n)); }
	 */
	public static void iterateMap(Map<String, String> Hacker) {
		for (Entry<String, String> entry : Hacker.entrySet()) {
			System.out.print(entry.getValue() + ", " + entry.getKey());
		}
	}
}

enum Name {
	Alice, Smith, Bob, Jones
}

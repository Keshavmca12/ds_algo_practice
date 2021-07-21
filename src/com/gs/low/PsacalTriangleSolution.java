package com.gs.low;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PsacalTriangleSolution {

	private static HashMap<List<Integer>, Integer> pascalVal = new HashMap<>();

	public static int pascal(int col, int row) {
		List<Integer> p = new ArrayList<>();
		p.add(row);
		p.add(col);
		if (!pascalVal.containsKey(p)) {
			System.out.println(col + " " + row);

			if (row == 0 || row == col || col == 0) {
				pascalVal.put(p, 1);
			} else {
				pascalVal.put(p, pascal(col, row - 1) + pascal(col - 1, row - 1));
			}
		}
		return pascalVal.get(p);

	}

	public static void main(String[] args) {
		if (PsacalTriangleSolution.pascal(0, 0) == 1 && PsacalTriangleSolution.pascal(1, 2) == 2
				&& PsacalTriangleSolution.pascal(5, 6) == 6 && PsacalTriangleSolution.pascal(4, 8) == 70
				&& PsacalTriangleSolution.pascal(6, 6) == 1) {
			System.out.println("Pass");
		} else {
			System.out.println("Failed");
		}
	}
}

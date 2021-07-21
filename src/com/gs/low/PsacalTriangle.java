package com.gs.low;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PsacalTriangle {

	public static Map<List<Integer>, Integer> resultMap = new HashMap<>();

	public static int pascal(int col, int row) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(row);
		list.add(col);
	
		if(row == 0 || col == 0 || (row == col)) {
			resultMap.put(list, 1);
		}else {
			/*if(resultMap.get(list) == null) {
				resultMap.put(list, pascal(col, row-1) + pascal(col-1, row-1));
			}*/
			resultMap.put(list, pascal(col, row-1) + pascal(col-1, row-1));	
		}
		System.out.println(resultMap);
		return resultMap.get(list);

	}

	public static void main(String[] args) {
		if (PsacalTriangle.pascal(0, 0) == 1 && PsacalTriangle.pascal(1, 2) == 2 && 
				PsacalTriangle.pascal(5, 6) == 6
				&& PsacalTriangle.pascal(4, 8) == 70 && PsacalTriangle.pascal(6, 6) == 1) {
			System.out.println("Pass");
		} else {
			System.out.println("Failed");
		}
	}
}

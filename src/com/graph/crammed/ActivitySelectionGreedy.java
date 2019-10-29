package com.graph.crammed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Autor : Keshav Kumar
 * @Date : 13-Dec-2018
 */

public class ActivitySelectionGreedy {

	static class TimeSequence implements Comparable<TimeSequence> {
		int start;
		int end;

		@Override
		public int compareTo(TimeSequence sequence) {
			if (end > sequence.end) {
				return 1;
			}

			if (end < sequence.end) {
				return -1;
			}
			return 0;
		}

		public TimeSequence() {
		}

		public TimeSequence(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "TimeSequence [start=" + start + ", end=" + end + "]";
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

	}

	public static void main(String[] args) {
		int startTime[] = { 5, 1, 5, 8, 3, 0 };
		int finishTime[] = { 9, 2, 7, 9, 4, 6 };

		/**
		 * Map removes duplicate while sorting so used list
		 */

		/*
		 * Map<Integer, Integer> arrayMap = new TreeMap<>(); for (int i = 0; i <
		 * f.length; i++) { arrayMap.put(f[i], s[i]); }
		 * 
		 * for (Map.Entry<Integer, Integer> entry : arrayMap.entrySet()) {
		 * System.err.println("key : " + entry.getKey() + "    value : " +
		 * entry.getValue()); }
		 */

		List<TimeSequence> storeList = new ArrayList<>();
		for (int i = 0; i < finishTime.length; i++) {
			storeList.add(new ActivitySelectionGreedy.TimeSequence(startTime[i], finishTime[i]));
		}

		System.out.println("before : " + storeList);

		Collections.sort(storeList);

		System.out.println("after : " + storeList);

		System.out.println("startTime : " + Arrays.toString(startTime));
		System.out.println("finishTime : " + Arrays.toString(finishTime));

		for (int i = 0; i < storeList.size(); i++) {
			TimeSequence temp = storeList.get(i);
			startTime[i] = temp.getStart();
			finishTime[i] = temp.getEnd();
		}

		System.out.println("*************after****************");

		System.out.println("startTime : " + Arrays.toString(startTime));
		System.out.println("finishTime : " + Arrays.toString(finishTime));

		activitySelection(startTime, finishTime);

	}

	private static void activitySelection(int[] startTime, int[] finishTime) {

		int current = 0;
		System.out.println("****************** Activity Index *****************");
		System.out.println(current);
		for (int j = 1; j < finishTime.length; j++) {
			
			if (startTime[j] >= finishTime[current]) {
				System.out.println(j);
				current = j;
			}
		}
	}
}

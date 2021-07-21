package com.paypal;

import java.util.*;
import java.util.Map.*;

public class SubArrayArrangementSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		int noOfTestCase = Integer.parseInt(n);
		Integer[][] inputArray = new Integer[noOfTestCase][];
		List<List<List<Integer>>> subArrayList = new ArrayList<>();
		for (int i = 0; i < noOfTestCase; i++) {
			String[] arraySubArraySizeArray = sc.nextLine().split(" ");
			int inputArrayLength = Integer.parseInt(arraySubArraySizeArray[0]);
			int noOfSubArray = Integer.parseInt(arraySubArraySizeArray[1]);
			inputArray[i] = new Integer[inputArrayLength];
			String[] inputArrayString = sc.nextLine().split(" ");
			for (int j = 0; j < inputArrayLength; j++) {
				inputArray[i][j] = Integer.parseInt(inputArrayString[j]);
			}
			List<List<Integer>> subArray = new ArrayList<>();
			for (int j = 0; j < noOfSubArray; j++) {
				String[] subArrayString = sc.nextLine().split(" ");
				List<Integer> subArrayItem = new ArrayList<>();
				subArrayItem.add(Integer.parseInt(subArrayString[0]));
				subArrayItem.add(Integer.parseInt(subArrayString[1]));
				subArray.add(subArrayItem);
			}
			subArrayList.add(subArray);
		}

		for (int i = 0; i < inputArray.length; i++) {
			int sum = getSubArraySumDifference(inputArray[i], subArrayList.get(i));
			System.out.println("sum : "+ sum);
		}
		sc.close();
	}

	private static int getSubArraySumDifference(Integer[] inputArray, List<List<Integer>> subArrayList) {
		System.out.println("list " +subArrayList);
		int sum = 0;
		int sumAfterArrangement = 0;
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (List<Integer> list : subArrayList) {
			for(int i= list.get(0)-1; i < list.get(1);i++) {
				if(!indexMap.containsKey(i)) {
					indexMap.put(i,1);
				}else {
					indexMap.put(i, indexMap.get(i) + 1);
				}
				sum = sum  + inputArray[i];
			}
		}
	
		Map<Integer, Integer> sortedvalueMap = sortMapByValue(indexMap);
		Arrays.sort(inputArray, Collections.reverseOrder());
		Integer[] arrangedArray = new Integer[inputArray.length];
		int index =0;
		System.out.println("Array AFter Arrangement : "+ Arrays.deepToString(inputArray));
		System.out.println("sortedvalueMap : " + sortedvalueMap );
		for (Entry<Integer, Integer> entry : sortedvalueMap.entrySet()) {
			arrangedArray[entry.getKey()] = inputArray[index++];
		}
		
		System.out.println("arrangedArray : "+ Arrays.deepToString(arrangedArray)); 
		System.out.println("sum  : " + sum);
		for (List<Integer> list : subArrayList) {
			for(int i= list.get(0)-1; i < list.get(1);i++) {
				sumAfterArrangement = sumAfterArrangement  + arrangedArray[i];
			}
		}
	
		System.out.println("sumAfterArrangement : "+sumAfterArrangement);


		return sumAfterArrangement - sum;
	}
	
	private static Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> indexMap){
		
		List<Entry<Integer, Integer>>  list =  new LinkedList<Map.Entry<Integer, Integer> >(indexMap.entrySet()); 
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
		
		  HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
	        for (Map.Entry<Integer, Integer> aa : list) { 
	            temp.put(aa.getKey(), aa.getValue()); 
	        } 
	        return temp; 
	}

}

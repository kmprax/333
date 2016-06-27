package edu.greenriver.it.sorting;

import java.util.*;

public class MergeSortTest{
	
	public static void main(String[]args){
		
		//test empty integer array
		Integer [] nums = new Integer[0];
		System.out.print("Before Merge : " + Arrays.toString(nums) + "\n");
		MergeSort.MergeSort(nums);
		System.out.print("After Merge : " + Arrays.toString(nums) + "\n\n");
		
		//test just two numbers integer array
		nums = new Integer[] { 1 };
		System.out.print("Before Merge : " + Arrays.toString(nums) + "\n");
		MergeSort.MergeSort(nums);
		System.out.print("After Merge : " + Arrays.toString(nums) + "\n\n");

		//test just two numbers integer array
		nums = new Integer[] { 31, 5 };
		System.out.print("Before Merge : " + Arrays.toString(nums) + "\n");
		MergeSort.MergeSort(nums);
		System.out.print("After Merge : " + Arrays.toString(nums) + "\n\n");
		
		//test string array of words
		String[]  stringTest = new String[] { "i", "hate", "when", "i", "get", "stuck", "for", "hours", "on", "java"};
		System.out.print("Before Merge : " + Arrays.toString(stringTest) + "\n");
		MergeSort.MergeSort(stringTest);
		System.out.print("After Merge : " + Arrays.toString(stringTest) + "\n\n");
		
		//test integer array numbers that are all the same
		nums = new Integer[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };
		System.out.print("Before Merge : " + Arrays.toString(nums) + "\n");
		MergeSort.MergeSort(nums);
		System.out.print("After Merge : " + Arrays.toString(nums) + "\n\n");
		
		//test integer array numbers that are backwards
		nums = new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.print("Before Merge : " + Arrays.toString(nums) + "\n");
		MergeSort.MergeSort(nums);
		System.out.print("After Merge : " + Arrays.toString(nums) + "\n\n");
		
		//test string array that is all start with "ab"
		stringTest = new String[] { "abstract", "about", "above", "abuse", "abroad", "ability", "absence", "abusive"};
		System.out.print("Before Merge : " + Arrays.toString(stringTest) + "\n");
		MergeSort.MergeSort(stringTest);
		System.out.print("After Merge : " + Arrays.toString(stringTest) + "\n\n");
		
		//test integer array of random numbers
		randomTest(100);
		randomTest(1000);
		randomTest(10000);
		randomTest(100000);
	}
	
	
	public static void randomTest(int sizeN){
		Integer [] nums = new Integer[sizeN];

		Random random = new Random();

		for(int i = 0; i < sizeN; i++){
			nums[i] = (random.nextInt(sizeN));
		}
		MergeSort.MergeSort(nums);
		System.out.println("All "+ sizeN +"elements "+ testRandom(nums)+ "\n");
	}
	
	public static String testRandom(Integer[] testArray){
		for (int i = 0; i < testArray.length - 1; i++) {
			if (testArray[i].compareTo(testArray[i + 1]) > 0) {
				return "weren't sorted correctly";
			}
		}

		return "were all sorted correctly";
	}
}

package edu.greenriver.it.AlgorithmAnalysis;


import java.util.Arrays;
import java.util.Random;


public class AlgorithmAnalysisLargeN{


	public static double counterOne = 0;
	public static double counterTwo = 0;
	public static double counterThree = 0;
	public static Random rand = new Random();


	public static void main(String [] args){

		findAverageAlgorithmOne();
		System.out.println();
		findAverageAlgorithmTwo();
		System.out.println();
		findAverageAlgorithmThree();
	}


	/**
	 * takes a array of integers loops through array and then loops through the
	 * calling the function 10 times with each number in the array, finds the
	 * average for that number in the array
	 */
	public static void findAverageAlgorithmOne(){
		int [] largeNValues = { 250, 500, 1000, 2000};
		for(int i = 0; i < largeNValues.length; i++){
			counterOne = 0;
			int n = largeNValues[i];
			for(int j = 0; j < 10; j++){
				algorithmOne(n);
			}
			System.out.println("Algorithm One when n is: " + n + " average is: " + (counterOne / 10));
		}

	}


	/**
	 * takes a array of integers loops through array and then loops through the
	 * calling the function 10 times with each number in the array, finds the
	 * average for that number in the array
	 */
	public static void findAverageAlgorithmTwo(){
		int [] largeNValues = { 25000, 50000, 100000, 200000, 400000, 800000};
		
		for(int i = 0; i < largeNValues.length; i++){
			counterTwo = 0;
			int n = largeNValues[i];
			for(int j = 0; j < 10; j++){
				algorithmTwo(n);
			}

			System.out.println("Algorithm Two when n is: " + n + " average is: " + (counterTwo / 10));
		}
	}


	/**
	 * takes a array of integers loops through array and then loops through the
	 * calling the function 10 times with each number in the array, finds the
	 * average for that number in the array
	 */
	public static void findAverageAlgorithmThree(){
		int [] largeNValues = { 100000, 200000, 400000, 800000, 1600000, 3200000, 6400000};
		
		for(int i = 0; i < largeNValues.length; i++){

			int n = largeNValues[i];
			for(int j = 0; j < 10; j++){
				algorithmThree(n);
			}
			System.out.println("Algorithm Three when n is: " + n + " average is: " + (counterThree / 10));
		}
	}


	/**
	 * checks index is less than array length, creates random number sets a
	 * boolean to true, runs a loop through the array to check random number
	 * isn't in the array, if the random number is the same as the array change
	 * boolean value to false, if the boolean is still true than add random
	 * number to array at current index
	 * 
	 * @param n
	 *            is the size of the array
	 * @return returns the array full of non-repeating random numbers
	 */
	public static int [] algorithmOne(int n){
		counterOne = 0;
		int i = 0;
		int [] numbers = new int[n];
		while(i < numbers.length){
			int randNum = rand.nextInt(n);
			boolean newNumber = true;

			for(int j = 0; j < i; j++){
				counterOne++; // determines number of operations
				if(numbers[j] == randNum){
					newNumber = false;

				}
			}
			if(newNumber){
				numbers[i] = randNum;
				i++;// moves i to next index value
			}
		}
		return numbers;
	}


	/**
	 * creates an array of booleans, creates a new array of numbers create a
	 * random number, loops through to the length of array checks to see if the
	 * random number -1 index is equal to true if it is get new random number,
	 * if it isn't then place random number in the index and then change that
	 * index to true
	 * 
	 * @param n
	 *            is the size of the array
	 * @return returns the array full of non-repeating random numbers
	 */
	public static int [] algorithmTwo(int n){
		counterTwo = 0;
		boolean [] usedNumbers = new boolean[n];// start all false

		int [] numbers = new int[n];
		int randNum = rand.nextInt(n) + 1;
		
		for(int i = 0; i < numbers.length; i++){
			while(usedNumbers[randNum - 1] == true){
				counterTwo++;// determines number of operations
				randNum = rand.nextInt(n) + 1;
				
			}
			
			numbers[i] = randNum;
			usedNumbers[randNum - 1] = true;
		}
		return numbers;
	}


	/**
	 * creates an array, creates random number loops through the array putting
	 * in a values for each array the index of the array plus 1, loops through
	 * the the number of n calls swapElements which then goes and swaps the
	 * elements at random.
	 * 
	 * @param n
	 *            is the size of the array
	 * @return returns the array full of non-repeating random numbers
	 */
	public static int [] algorithmThree(int n){
		counterThree = 0;
		int [] numbers = new int[n];
		int randNum = rand.nextInt(n) + 1;
		for(int i = 0; i < numbers.length; i++){

			numbers[i] = i + 1;
		}
		for(int i = 0; i < n; i++){
			counterThree++;// determines number of operations
			swapElements(i, randNum, numbers);
		}
		return numbers;
	}


	/**
	 * turns the index of the iteration from the loop before and puts it into a
	 * temporary holder interimNum then makes the random number the index of
	 * what the number in interimNum was in then places the number in interimNum
	 * into the index the random number came from.
	 * 
	 * @param value
	 *            is the iteration of the loop
	 * @param randNum
	 *            is the random number made by the generator
	 * @param numbers
	 *            is the array holding the numbers.
	 */
	public static void swapElements(int value, int randNum, int [] numbers){
		int interimNum = numbers[value];
		numbers[value] = numbers[randNum];
		numbers[randNum] = interimNum;
	}


}

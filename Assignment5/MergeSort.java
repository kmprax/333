package edu.greenriver.it.sorting;


public class MergeSort{


	/**
	 * takes an array determines the length and sends it on to the merge sort
	 * function that will sort the list.
	 * 
	 * @param inArray
	 *            array that needs to be sorted
	 */
	public static <T extends Comparable<T>> void MergeSort(T [] inArray){
		MergeSort(inArray, 0, inArray.length - 1);
	}


	/**
	 * gets the array the start and end of array then it determines how many
	 * elements in array if two does swap if one returns array if 3 or more
	 * starts recursive calls and then sends over to the merge to sort the
	 * elements.
	 * 
	 * @param inArray
	 *            array that needs to be sorted
	 * @param start
	 *            starting index of the array
	 * @param end
	 *            last index of the array
	 */
	public static <T extends Comparable<T>> void MergeSort(T [] inArray, int start, int end){

		int elementsTotal = end - start + 1;

		if(elementsTotal >= 3){// if 3 or more elements
			int midPoint1 = start + elementsTotal / 3 - 1; // find first
															// midpoint
			int midPoint2 = start + 2 * elementsTotal / 3 - 1; // find second
																// midpoint
			// start the recursive part breaks it down into smaller arrays to go
			// through merge
			MergeSort(inArray, start, midPoint1);
			MergeSort(inArray, midPoint1 + 1, midPoint2);
			MergeSort(inArray, midPoint2 + 1, end);

			merge(inArray, start, midPoint1, midPoint1 + 1, midPoint2, midPoint2 + 1, end);

		}else if(elementsTotal == 2){ // if only two elements
			if(inArray[start].compareTo(inArray[end]) < 0){// check if in order
				return;// if so return
			}else{// if not swap
				T interim = inArray[start];
				inArray[start] = inArray[end];
				inArray[end] = interim;
			}
		}else{ // elementsTotal is equal to 1 return since nothing to compare
			return;
		}
	}


	/**
	 * merges sub-arrays into one array
	 * 
	 * @param inArray
	 *            array that needs to be sorted
	 * @param low1
	 *            the starting index of sub-array 1
	 * @param high1
	 *            the ending index of sub-array 1
	 * @param low2
	 *            the starting index of sub-array 2
	 * @param high2
	 *            the ending index of sub-array 2
	 * @param low3
	 *            the starting index of sub-array 3
	 * @param high3
	 *            the ending index of sub-array 3
	 */
	public static <T extends Comparable<T>> void merge(T [] inArray, int low1, int high1, int low2, int high2, int low3,
			int high3){
		int oneLength = high1 - low1 + 1; // find length of one
		int twoLength = high2 - low2 + 1; // find length of two
		int threeLength = high3 - low3 + 1; // find length of three

		int first = low1; // create array pointer for one
		int second = low2;// create array pointer for two
		int third = low3;// create array pointer for three


		int newLow1 = low1;// create newLow1 so can use 1 later during transfer
		int interimLength = oneLength + twoLength + threeLength;// total of all
		int newIndex = 0; // create an index pointer for location inside interim
							// array

		T [] interimArray = (T [])new Comparable[interimLength]; // create
																	// interim
																	// array
		for(int i = 0; i < interimLength; i++){
			if(inArray[first].compareTo(inArray[second]) < 0){
				if(inArray[first].compareTo(inArray[third]) < 0){
					interimArray[newLow1++] = inArray[first++];
				}else{
					interimArray[newLow1++] = inArray[third++];
				}
			}else{
				if(inArray[second].compareTo(inArray[third]) < 0){
					interimArray[newLow1++] = inArray[second++];
				}else{
					interimArray[newLow1++] = inArray[third++];
				}
			}
			if(inArray[first].compareTo(inArray[second]) < 0){
				interimArray[newLow1++] = inArray[first++];
			}else{
				interimArray[newLow1++] = inArray[second++];
			}
			if(inArray[second].compareTo(inArray[third]) < 0){
				interimArray[newLow1++] = inArray[second++];
			}else{
				interimArray[newLow1++] = inArray[third++];
			}
			if(inArray[first].compareTo(inArray[third]) < 0){
				interimArray[newLow1++] = inArray[first++];
			}else{
				interimArray[newLow1++] = inArray[third++];
			}
		}
		// places elements out of the interim array
		// and back in the inArray
		newIndex = 0;
		for(int i = low1; i <= high3; i++){
			inArray[i] = interimArray[newIndex];
			++newIndex;
		}
	}
}

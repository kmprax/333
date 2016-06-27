/*
 * Kimberly M. Praxel
 * 5/22/16
 * EmptyHeap.java
 * My attempt at a custom ternaryHeap
 */

package edu.greenriver.it.heaps;


import java.util.*;



/**
 * My attempt to make a complete ternary tree
 * 
 * @author Kimberly M. Praxel
 * @version 1.0
 */


public class EmptyHeap<T extends Comparable<T>> implements Queue<T>{
	
	private static final int ITITIAL_SIZE = 10;
	
	//complete heap
	private T[] ternaryHeap;
	
	//counters
	private int size;
	private int nextIndex = 1;
	
	/**
	 * create empty ternaryHeap with an size of 20
	 */
	@SuppressWarnings("unchecked")
	public EmptyHeap(){
		ternaryHeap = (T[]) new Comparable[ITITIAL_SIZE + 10 ];
	}
	
	/**
	 * create ternaryHeap faster
	 * 
	 * @param array 
	 */
	@SuppressWarnings("unchecked")
	public EmptyHeap(T[] array){
		ternaryHeap = (T[]) new Comparable [array.length + 1];
		
		for(int i = 0; i < array.length; i++){
			ternaryHeap[i + 1] = array[i];
		}
		
		//housekeeping 
		size = array.length;
		nextIndex = size + 1;
		
		//build heap operation
		buildHeap();
	}
	
	/*
	 * builds help and places it in order
	 */
	private void buildHeap(){
		
		//starts with the highest index node with a child node
		for(int i = size / 3; i>= 1; i--){
			percolateDown(i);
		}
	}
	
	

	/**
	 * adds elements to the ternary heap 
	 */
	@Override
	public boolean add(T newElement){ // insert() operation
		
		//have we run out of space in our internal array?
		if(nextIndex == ternaryHeap.length){
			resize();//doubles the size of our array
		}
		
		//place the element at the end of the complete binary
		//tree and percolate up
		ternaryHeap[nextIndex] = newElement;
		percolateUp(nextIndex);
		
		//move to the next index and increment the size
		nextIndex++;
		size++;
		
		return true;
	}
	
	/*
	 * orders the heap up 
	 * 
	 * @param index where the reorder starts
	 */
	private void percolateUp(int index){
		
		//continue as long as the current index
		//is not equal to the root
		while(index > 1){
			int parentIndex = (index + 1) / 3;
			
			//check whether the parent and child node are out of order
			if(ternaryHeap[index].compareTo(ternaryHeap[parentIndex])< 0 ){
				swap(index, parentIndex);
			}
			
			//move up to the parent continue to loop
			index = parentIndex;
		}
	}
	
	/**
	 * doubles the length of the heap
	 */
	@SuppressWarnings("unchecked")
	public void resize(){
		
		//double the size of our array
		T[] newTernaryHeap = (T[]) new Comparable[ternaryHeap.length * 2];
		
		//copy across elements to the new heap
		for(int i = 0; i < ternaryHeap.length; i++){
			newTernaryHeap[i] = ternaryHeap[i];
		}
		
		//replace old heap with new heap
		ternaryHeap = newTernaryHeap;
	}

	/**
	 * finds the min number in heap
	 */
	@Override
	public T peek(){ // findMin() operation
		if(size == 0){
			throw new NoSuchElementException("The heap is empty");
		}
		return ternaryHeap[1];
	}

	/**
	 * deletes the min number of the heap and then percolatesDown the heap to reorder
	 */
	@Override
	public T remove(){ // deleteMin() operation
				
		//make sure we don't call remove() with no elements
		if(isEmpty()){
			throw new NoSuchElementException("The heap is empty");
		}
				
		//save our element to return
		T element = ternaryHeap[1];
		
		//move the last element of the heap which is at (size) to 
		//the first location in the heap. 
		swap(1, size);
				
		//alter our indices
		size--;
		nextIndex--;
				
		//now restructure heap with percolateDown the element
		//to the correct position
		percolateDown(1);
				
		return element;
	}
	
	/**
	 * orders the heap down
	 * @param index where the percolateDown starts 
	 */
private void percolateDown(int index){
		
		T elementSaved = ternaryHeap[index];
		
		//the last node with a child node is index at size/3
		while(index <= size / 3){
			
			//get child indices
			int left = (3 * index) - 1;
			int right = (3 * index) + 1;
			int middle = 3 * index;
			
			//determine which child is the smallest
			int indexToCheck = left;
		
			
			//if we have a right child, and the right child is smaller than middle
			if(middle < size && ternaryHeap[middle].compareTo(ternaryHeap[left]) < 0){
				indexToCheck = middle;
			}
			
			//if we have a middle child, and the middle child is smaller than right
			if(right < size && ternaryHeap[right].compareTo(ternaryHeap[indexToCheck]) < 0){
				indexToCheck = right;
			}
						
			//is the parent(indexToCheckC) smaller than the smallest child
			if(ternaryHeap[indexToCheck].compareTo(ternaryHeap[index]) < 0){
				
				//swap
				swap(indexToCheck, index);
				
				//move to that child node and do the same
				index = indexToCheck;
			}else{
				break;//exit our loop, heap order is satisfied
			}
			
		}
	}
	
	/*
	 * moves two numbers to each other indexs
	 */
	private void swap(int first, int second){
		T temp = ternaryHeap[first];
		ternaryHeap[first] = ternaryHeap[second];
		ternaryHeap[second] = temp;
	}


	/*
	 * returns the size of the heap
	 * (non-Javadoc)
	 * @see java.util.Collection#size()
	 */
	@Override
	public int size(){
		return size;
	}


	/*
	 * returns if the heap is empty
	 * (non-Javadoc)
	 * @see java.util.Collection#isEmpty()
	 */
	@Override
	public boolean isEmpty(){
		return size == 0;
	}

	/*
	 *clears the heap 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear(){
		size = 0;
		nextIndex = 1;
		ternaryHeap = (T[]) new Comparable [ITITIAL_SIZE + 1];

	}
	
	/**
	 * places heap into a readable String
	 */
	  public String toString() {
		    String v = ("[");
	        String w = ("]");
		  	String s = "";
	        for (T n : ternaryHeap) {
	           s += n + ", ";
	        }
	        String x = v + s + w;
	        return x;
	    }

	/* *********************************
	      ignore methods below this
	********************************** */
	
	@Override
	public boolean remove(Object search){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public boolean contains(Object search){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public T poll(){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public T element(){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public boolean offer(T e){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public boolean addAll(Collection<? extends T> c){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public boolean containsAll(Collection<?> c){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public boolean removeAll(Collection<?> c){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public boolean retainAll(Collection<?> c){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public Iterator<T> iterator(){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public Object [] toArray(){
		throw new UnsupportedOperationException("Method not supported.");
	}


	@Override
	public <T> T [] toArray(T [] a){
		throw new UnsupportedOperationException("Method not supported.");
	}
}
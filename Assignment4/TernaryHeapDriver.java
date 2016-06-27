package edu.greenriver.it.heaps;


import java.util.*;


public class TernaryHeapDriver{

	public static void main(String [] args){

		// addTest();
		// removeTest();
		// emptyTreeTest();
		// oneTreeTest();
		// keepRemoving();
		// randomQueue(100);
		// randomQueue(1000);
		// randomQueue(10000);
		 randomQueue(100000);
	}


	public static void addTest(){
		EmptyHeap<String> heap = new EmptyHeap<String>();
		heap.add("A");
		heap.add("B");
		heap.add("C");
		heap.add("D");
		heap.add("E");
		heap.add("F");
		heap.add("G");
		System.out.println(heap);

		EmptyHeap<Integer> numbersHeap = new EmptyHeap<Integer>();
		for(int i = 0; i < 10; i++){
			numbersHeap.add(i);
		}
		System.out.println(numbersHeap);
	}


	public static void removeTest(){
		EmptyHeap<Integer> numberHeap = new EmptyHeap<Integer>();
		for(int i = 0; i < 10; i++){
			numberHeap.add(i);
		}
		numberHeap.remove();
		System.out.println(numberHeap);
		numberHeap.remove();
		System.out.println(numberHeap);
		numberHeap.remove();
		System.out.println(numberHeap);
		numberHeap.remove();
		System.out.println(numberHeap);
		numberHeap.remove();
		System.out.println(numberHeap);
		numberHeap.remove();
		System.out.println(numberHeap);
	}


	public static void emptyTreeTest(){
		EmptyHeap<Integer> emptyHeap = new EmptyHeap<Integer>();
		System.out.println("Removing from empty tree: " + emptyHeap.remove());
	}


	public static void oneTreeTest(){
		EmptyHeap<Integer> emptyHeap2 = new EmptyHeap<Integer>();
		emptyHeap2.add(1);
		System.out.println("Removing from a single element tree: " + emptyHeap2.remove());
	}


	public static void keepRemoving(){
		EmptyHeap<Integer> tenHeap = new EmptyHeap<Integer>();
		for(int i = 1; i < 10; i++){
			tenHeap.add(i);
		}
		System.out.println(tenHeap);
		while(!tenHeap.isEmpty()){
			tenHeap.remove();
			System.out.println(tenHeap);
		}
	}


	public static void randomQueue(int sizeN){
		Integer [] input = new Integer[sizeN];

		Random random = new Random();

		for(int i = 0; i < sizeN; i++){
			input[i] = (random.nextInt(sizeN));
		}
		
		// use buildHeap()

		EmptyHeap<Integer> queue = new EmptyHeap<Integer>(input);// O(n),
																	// not
																	// O(nlogn)
		while(!queue.isEmpty()){
			System.out.println(queue.remove());
		}
	}
}


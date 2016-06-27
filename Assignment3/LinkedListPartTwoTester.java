package edu.greenriver.tech.it.listparttwo;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListPartTwoTester{

	public static void main(String [] args){
		//testAddAll();
		//testContainsAll();
		testRemoveAll();
		//testRetainAll();
		//testSubList();
		//testToArray();
		//testToGenericArray();
		//testIterator();
	}
	
	public static void testAddAll(){
		LinkedListPartTwo<Integer> list1 = new LinkedListPartTwo<Integer>();
		for (int i = 0; i < 10; i++){
			list1.add(i);
		}
		System.out.println("List 1: " + list1.toString());
		System.out.println();
		LinkedListPartTwo<Integer> list2 = new LinkedListPartTwo<Integer>();
		for (int i = 0; i < 10; i++){
			list2.add(i);
		}
		System.out.println("List 2: " + list2.toString());
		System.out.println();
		//first addAll with no index
		list1.addAll(list2);
		System.out.println("List 2 added to list 1" + list1.toString());
		//second addAll with index
		System.out.println();
		list1.addAll(1, list2);
		System.out.println("List 2 added to list 1 at given index" + list1.toString());
		
	}
	
	
	public static void testContainsAll(){
		LinkedListPartTwo<Integer> list1 = new LinkedListPartTwo<Integer>();
		for (int i = 0; i < 10; i++){
			list1.add(i);
		}
		System.out.println("List 1: " + list1.toString());
		System.out.println();
		
		
		LinkedListPartTwo<Integer> list2 = new LinkedListPartTwo<Integer>();
		for (int i = 0; i < 10; i++){
			list2.add(i);
		}
		System.out.println("List 2: " + list2.toString());
		System.out.println();
		
		
		
		LinkedListPartTwo<Integer> list3 = new LinkedListPartTwo<Integer>();
		for (int i = 0; i < 15; i++){
			list3.add(i);
		}
		System.out.println("List 3: " + list3.toString());
		System.out.println();
		
		
		LinkedListPartTwo<Integer> list4 = new LinkedListPartTwo<Integer>();
		for (int i = 0; i < 20; i++){
			list4.add(i);
		}
		System.out.println("List 4: " + list4.toString());
		System.out.println();
		
		System.out.println("Does List 1 contain list 2? " + list1.containsAll(list2));
		System.out.println("Does List 4 contain list 3? " + list4.containsAll(list3));
		System.out.println("Does List 3 contain list 4? " + list3.containsAll(list4));
	}
	
	public static void testRemoveAll(){
		LinkedListPartTwo<Integer> list1 = new LinkedListPartTwo<Integer>();
		for (int i = 0; i < 10; i++){
			list1.add(i);
		}
		System.out.println("LinkedList 1: " + list1.toString());
		System.out.println();
		
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i = 2; i < 5; i++){
			list2.add(i);
		}
		System.out.println("ArrayList 2: " + list2.toString());
		System.out.println();
		
		
		
		LinkedListPartTwo<Integer> list3 = new LinkedListPartTwo<Integer>();
		for (int i = 0; i < 15; i++){
			list3.add(i);
		}
		System.out.println("List 3: " + list3.toString());
		System.out.println();
		
		
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		for (int i = 10; i < 20; i++){
			list4.add(i);
		}
		System.out.println("List 4: " + list4.toString());
		System.out.println();
		
		
		list1.removeAll(list2);
		System.out.println("After removeAll: " + list1.toString());
		System.out.println();
		
		
		list4.removeAll(list3);
		System.out.print("After removeAll: " + list4.toString());
		
		
	}
	
		
	

}

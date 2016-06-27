/*
 * Kimberly M. Praxel
 * 4/24/16
 * ListTester.java
 * My LinkList Tester 
 */


package edu.greenriver.tech.it.lists;

public class ListTester{
	public static void main(String [] args){
		//run the tests
		testAdd();
		testInsert();
		testIsEmpty();
		testSize();
		testClear();
		testIndexOf();
		testContains();
		testGet();
		testSet();
		testRemoveIndex();
		testRemoveElement();
		
	}


	public static void testAdd(){
		// this method tests list.add(element)
		ListImplementationPartOne<Integer> test1 = new ListImplementationPartOne<Integer>();
		System.out.println("Test Add");
		System.out.println("---------------");
		System.out.println("Current List");
		System.out.println(test1.toString());
		System.out.println(test1.add(1));
		System.out.println(test1.add(3));
		System.out.println(test1.add(12));
		System.out.println(test1.add(21));
		System.out.println(test1.add(31));
		System.out.println(test1.add(29));
		System.out.println(test1.add(14));
		System.out.println("List after adds");
		System.out.println(test1.toString());
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");
	}


	public static void testInsert(){
		// this method tests list.add(index, element)
		ListImplementationPartOne<Integer> test2 = new ListImplementationPartOne<Integer>();
		System.out.println("Test insert");
		System.out.println("---------------");
		System.out.println("Current List");
		System.out.println(test2.toString());
		test2.add(0, 5);
		test2.add(1, 5);
		test2.add(2, 5);
		test2.add(3, 5);
		System.out.println("Current List after adds");
		System.out.println(test2.toString());
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");

	}


	public static void testIsEmpty(){
		// this method tests list.isEmpty()
		ListImplementationPartOne<Integer> test3 = new ListImplementationPartOne<Integer>();
		System.out.println("Test empty");
		System.out.println("---------------");
		System.out.println("Current List");
		System.out.println(test3.toString());
		System.out.println("Is the list empty?");
		System.out.println(test3.isEmpty());
		System.out.println(test3.add(1));
		System.out.println(test3.add(3));
		System.out.println(test3.add(12));
		System.out.println(test3.add(21));
		System.out.println(test3.add(31));
		System.out.println(test3.add(29));
		System.out.println(test3.add(14));
		System.out.println("Current List");
		System.out.println(test3.toString());
		System.out.println("Is the list empty?");
		System.out.println(test3.isEmpty());
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");
		
	
	}


	public static void testSize(){
		// this method tests list.size()
		ListImplementationPartOne<Integer> test4 = new ListImplementationPartOne<Integer>();
		System.out.println("Test size");
		System.out.println("---------------");
		System.out.println("Current List");
		System.out.println(test4.toString());
		System.out.println("Current Size");
		System.out.println(test4.size());
		System.out.println(test4.add(1));
		System.out.println(test4.add(3));
		System.out.println(test4.add(12));
		System.out.println(test4.add(21));
		System.out.println(test4.add(31));
		System.out.println(test4.add(29));
		System.out.println(test4.add(14));
		System.out.println("Current List");
		System.out.println(test4.toString());
		System.out.println("Current Size");
		System.out.println(test4.size());
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");
	}


	public static void testClear(){
		// this method tests list.clear()
		ListImplementationPartOne<Integer> test5 = new ListImplementationPartOne<Integer>();
		System.out.println("Test clear");
		System.out.println("---------------");
		System.out.println("Current List");
		System.out.println(test5.toString());
		System.out.println(test5.add(1));
		System.out.println(test5.add(3));
		System.out.println(test5.add(12));
		System.out.println(test5.add(21));
		System.out.println(test5.add(31));
		System.out.println(test5.add(29));
		System.out.println(test5.add(14));
		System.out.println("Current List");
		System.out.println(test5.toString());
		test5.clear();
		System.out.println("List after clear");
		System.out.println(test5.toString());
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");
	}


	public static void testIndexOf(){
		// this method tests list.indexOf(element)
		ListImplementationPartOne<Integer> test6 = new ListImplementationPartOne<Integer>();
		System.out.println("Test index of");
		System.out.println("---------------");
		System.out.println(test6.add(1));
		System.out.println(test6.add(3));
		System.out.println(test6.add(12));
		System.out.println(test6.add(21));
		System.out.println(test6.add(31));
		System.out.println(test6.add(29));
		System.out.println(test6.add(14));
		System.out.println("Current List");
		System.out.println(test6.toString());
		System.out.println(test6.indexOf(3));
		
		System.out.println(test6.indexOf(21));
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");
	}
	


	public static void testContains(){
		// this method tests list.contains(element)
		ListImplementationPartOne<Integer> test7 = new ListImplementationPartOne<Integer>();
		System.out.println("Test add second");
		System.out.println("---------------");
		System.out.println(test7.add(1));
		System.out.println(test7.add(3));
		System.out.println(test7.add(12));
		System.out.println(test7.add(21));
		System.out.println(test7.add(31));
		System.out.println(test7.add(29));
		System.out.println(test7.add(14));
		System.out.println("Current List");
		System.out.println(test7.toString());
		System.out.println(test7.contains(3));
		System.out.println(test7.contains(31));
		System.out.println(test7.contains(32));
		System.out.println(test7.contains(14));
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");
	}


	public static void testGet(){
		// this method tests list.get(index)
		ListImplementationPartOne<Integer> test8 = new ListImplementationPartOne<Integer>();
		System.out.println("Test get");
		System.out.println("---------------");
		System.out.println(test8.add(1));
		System.out.println(test8.add(3));
		System.out.println(test8.add(12));
		System.out.println(test8.add(21));
		System.out.println(test8.add(31));
		System.out.println(test8.add(29));
		System.out.println(test8.add(14));
		System.out.println("Current List");
		System.out.println(test8.toString());
		System.out.println(test8.get(0));
		System.out.println(test8.get(1));
		System.out.println(test8.get(2));
		System.out.println(test8.get(3));
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");
	}


	public static void testSet(){
		// this method tests list.set(index, element)
		ListImplementationPartOne<Integer> test9 = new ListImplementationPartOne<Integer>();
		System.out.println("Test set");
		System.out.println("---------------");
		System.out.println(test9.add(1));
		System.out.println(test9.add(3));
		System.out.println(test9.add(12));
		System.out.println(test9.add(21));
		System.out.println(test9.add(31));
		System.out.println(test9.add(29));
		System.out.println(test9.add(14));
		System.out.println("Current List");
		System.out.println(test9.toString());
		System.out.println(test9.set(0, 1));
		System.out.println(test9.set(1, 2));
		System.out.println(test9.set(2, 3));
		System.out.println(test9.set(3, 4));
		System.out.println(test9.set(4, 5));
		System.out.println("Current List");
		System.out.println(test9.toString());
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");
	}


	public static void testRemoveElement(){
		// this method tests list.remove(element)
		ListImplementationPartOne<String> test10 = new ListImplementationPartOne<String>();
		System.out.println("Test remove element");
		System.out.println("---------------");
		System.out.println(test10.add("I "));
		System.out.println(test10.add("hate "));
		System.out.println(test10.add("Java "));
		System.out.println(test10.add("Why "));
		System.out.println(test10.add("Am "));
		System.out.println(test10.add("I "));
		System.out.println(test10.add("So "));
		System.out.println(test10.add("dumb?"));
		
		System.out.println("Current List");
		System.out.println(test10.toString());
		System.out.println(test10.remove("hate "));
		System.out.println(test10.remove("dumb?"));
		System.out.println(test10.add("good?"));
		System.out.println("Current List");
		System.out.println(test10.toString());
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");

	}


	public static void testRemoveIndex(){
		// this method tests list.remove(index)
		ListImplementationPartOne<Integer> test11 = new ListImplementationPartOne<Integer>();
		System.out.println("Test remove index");
		System.out.println("---------------");
		System.out.println(test11.add(1));
		System.out.println(test11.add(3));
		System.out.println(test11.add(12));
		System.out.println(test11.add(21));
		System.out.println(test11.add(31));
		System.out.println(test11.add(29));
		System.out.println(test11.add(14));
		System.out.println("Current List");
		System.out.println(test11.toString());
		System.out.println(test11.remove(1));
		System.out.println(test11.remove(2));
		System.out.println(test11.remove(3));
		System.out.println("Current List");
		System.out.println(test11.toString());
		System.out.println("####################################################");
		System.out.println("");
		System.out.println("####################################################");

	}
}

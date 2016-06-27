package edu.greenriver.it.heaps;

public class SubmissionQuestions{

	public static void main(String [] args){
		questionOne();
		questionTwo();
		questionThreeA();
		questionThreeB();
		

	}
	
	public static void questionOne(){
		System.out.println("1. What are the advantages/disadvantages of your design above?\n");
		System.out.println("The advantage of a ternary heap over a binary heap is that a \n"
				+ "ternary heap is shallower than a binary heap. The disadvantage of \n"
				+ "a ternary heap over a binary heap is that you have to compare more nodes\n"
				+ "than you would with a binary heap\n\n");
	}
	
	
	public static void questionTwo(){
		System.out.println("2. Would you use a ternary heap or binary heap in your own code? Why?\n");
		System.out.println("I think I would stay with the binary heap, its easy to read and there are no\n"
				+ "real benefits to the ternary heap. No giant performance benefits of the ternary \n"
				+ "over Binary. So I will just stick to the binary\n\n");
	}
	
	public static void questionThreeA(){
		System.out.println("3A. What is the big-oh for each of the operations on a ternary heap?\n");
		System.out.println("add(element) = 0(logn) or O(n) depending on how it is performed");
		System.out.println("peek() = 0(1)");
		System.out.println("remove() = 0(logn)");
		System.out.println("size() = 0(1)");
		System.out.println("isEmpty() = O(1)");
		System.out.println("clear() = O(1)\n\n");
	}
	
	public static void questionThreeB(){
		System.out.println("3A. How is the big-oh estimation for these functions different from the estimates for a binary heap.\n");
		System.out.println("I don't think they are different. I think that a binary heap and a ternary heap have the same big-oh estimates.");
	}
}
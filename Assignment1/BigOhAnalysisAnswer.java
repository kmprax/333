package edu.greenriver.it.AlgorithmAnalysis;


public class BigOhAnalysisAnswer{

	public static void main(String [] args){
		partAAlgorithmOne();
		partAAlgorithmTwo();
		partAAlgorithmThree();

	}


	public static void partAAlgorithmOne(){
		System.out.println(
				"Algorithm One - So in my algorithm \n"
				+ "one I believe it is O(n^2) the \n"
				+ "reason I believe this is because \n"
				+ "the way I coded the algorithm it \n"
				+ "has a total of 2 loops. It contains\n"
				+ "a while loop and inside the while\n"
				+ "loop is a for loop. Which makes \n"
				+ "me think that if my N value is \n"
				+ "250, then my operations should \n"
				+ "be around 62,500\n\n");
	}
	
	public static void partAAlgorithmTwo(){
		System.out.println("Algorithm Two - So in my algorithm one \n"
				+ "I believe it is O(n^2) the reason I think this \n"
				+ "is because the way I coded the algorithm it has a \n"
				+ "total of 2 loops. It contains a for loop and\n "
				+ "inside the for loop is a while loop. Total of \n"
				+ "2 loops so n^2. Which makes me think that if my\n"
				+ "N value is 25,000, then my operations should \n"
				+ "be around 625000000. Except mine didn't preform\n"
				+ "like this at all actualy i got more n^1 numbers\n\n");
	}
	
	public static void partAAlgorithmThree(){
		System.out.println("Algorithm Three - So in my algorithm \n"
				+ "three I believe it is O(n) the reason I think \n"
				+ "this is because the way I coded the algorithm \n"
				+ "it has a total of 2 loops. But no nested loops \n"
				+ "so.  Which makes me believe that if my N value\n"
				+ "is 100,000, then my operations should be \n"
				+ "around 100,000. ");
	}

}

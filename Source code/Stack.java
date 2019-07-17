/*
 * Name:		Katarina Capalbo n01399315
 * Date:		6/7/2019
 * Assignment:	Project 2 Data Stuctures
 * 
 * Description: Read in an infix expression and convert to postfix using the Stack ADT. Assume that the infix expression 
 * that we read has no spaces at all between
 * the operands, operators, and parenthesis, that all the operands are integers in the range 0..9, and that the
 * only operators allowed are +, *, and /.
 */

// start Stack class
class Stack {
	 private int count = 0; //number of elements in the stack
	 private int top = -1; //top element of the stack.
	 //top == -1 if the stack is empty
	 private int MAXSIZE = 1000; //Physical size of the stack
	 private int [] array;
	 
	 //constructor
	 public Stack( ) {
		 array = new int[MAXSIZE];
	 }
	 
	 //inspectors

	//Returns true if the stack is empty. Otherwise returns false.
	 public boolean stackEmpty() {
		return (top == -1) ? true : false;
	 }
	
	//Returns the top element of the stack
	 public int stackTop() {
	 return array[top];
	 }
	 
	//Returns the number of elements in the stack
	 public int stackCount() {
		 return count;
	 }
	
	 //Returns the elements of the stack with the following format:
	 //< E1 E2 E3 ... En> where E1 is at the bottom of the stack
	 //and En is at the top of the stack.
	 public String toString() {
		String elements = "<";
		
		for(int i = 0; i < count; i++) {
			elements += " " + array[i];
			}
		
			elements += " >";
			return elements;
	 }
	 
	 //Returns the elements of the stack with the following format:
	 //< E1 E2 E3 ... En> where E1 is at the bottom of the stack
	 //and En is at the top of the stack.
	 //The elements are printed to the returning string as chars.
	 public String printCharStack() {
		 String elements = "<";
		 
		for(int i = 0; i < count; i++) {
			elements += " " + (char)array[i];
				}
			
			elements += ">";
			return elements;
	 }
	 
	 
	 //modifiers
	 
	//Pushes element to the top of the stack.
	//Assumes that we will not run out of space in the stack.
	 public void stackPush(int element) {
		top++;
		array[top] = element;
		count++;
	 }
	 
	 //Pops out the top element of the stack.
	 //Returns true if the operation was successful.
	 //Returns false otherwise.
	 public boolean stackPop() {
		 if(stackEmpty())
		 {
			 return false;
		 }
		 else
		 {
		    if(top == 0)
		    {
		    	top = -1;
		    	count--;
		    }
		    else
		    {
		    	array[top] = array[top-1];
		    	top--;
		    	count--;
		    }
			 return true;
		 } 	
	 }
} // end Stack class
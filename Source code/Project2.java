/*
 * Name:		Katarina Capalbo
 * Student ID:		n01399315
 * Date:		6/7/2019
 * Assignment:		Project 2 Data Stuctures
 * 
 * Description: Read in an infix expression and convert to postfix using the Stack ADT. Assume that the infix expression 
 * that we read has no spaces at all between
 * the operands, operators, and parenthesis, that all the operands are integers in the range 0..9, and that the
 * only operators allowed are +, *, and /.
 */

import java.util.Scanner;

// start Project2 class
class Project2 {
	
// start main
 public static void main(String args[]) {
	 
 // declarations
 String infixExp = ""; //infix expression to be read
 Scanner scan = new Scanner(System.in);
 
 // prompt user to enter an infix expression
 System.out.printf("Enter an infix expression: "); 
 infixExp = scan.nextLine();

 // Final postfix output
 System.out.printf("The expression in postfix notation is " + convertToPostFix(infixExp) + "\n");
 	
 } // end main
 
 
 // returns the postfix equivalent string of an infix expression
 public static String convertToPostFix(String infixExp)
 {
	 // variable declarations
	 String postfixExp = ""; //postfix expression to be computed
	 Stack S = new Stack(); //stack for converting the infix expression to postfix notation
	 
	 //start for loop
	 for(int i = 0; i < infixExp.length(); i++)
	 {
		 // print out char being evaluated
		 System.out.printf(infixExp.charAt(i) + ":\t");
		 
		 // if char is an operand, append to the end of the postfixExp
		 if(Character.isDigit(infixExp.charAt(i)))
		 {
			 postfixExp += infixExp.charAt(i);
		 }
		 else if(infixExp.charAt(i) == '(') // push onto the stack
		 {
			 S.stackPush((int)infixExp.charAt(i));
		 }
		 else if(infixExp.charAt(i) == ')') // pop operands between ( ) 
		 {
			 while((precedence((char)S.stackTop()) > precedence(infixExp.charAt(i))) && !S.stackEmpty())
			 {
				 if((char)S.stackTop() == '(')
				 {
					 S.stackPop(); 
					 break;
				 }
				 else{
					 postfixExp +=(char)S.stackTop();
					 S.stackPop();
					 System.out.printf("%-10s %-10s \n", postfixExp, S.printCharStack());
				 } 
			 }
		 }
		 else {
			 if(S.stackEmpty()) // if the stack is empty, just push the operator onto the stack
			 {
				 S.stackPush((int)infixExp.charAt(i));
			 }
			 else // pop operators of greater or equal precedence from the stack and append them to postfixExp
			 {
				 int topStack = precedence((char)S.stackTop());
				 int infixChar = precedence(infixExp.charAt(i));
				 int p1 = '(';
					while((topStack > infixChar) && !S.stackEmpty() && (((char)S.stackTop()) != p1))
					{
						 postfixExp += (char)S.stackTop();
						 S.stackPop();
					}
					
					 S.stackPush(infixExp.charAt(i));
			 }
		 }
		 
		 // print out current postfixExp and Stack
		  System.out.printf("%-10s %-10s \n", postfixExp, S.printCharStack());

	 	}// end for loop
	  
	 // append remaining operators
	 while(!S.stackEmpty())
	 {
		 postfixExp += (char)S.stackTop();
		 S.stackPop();
		 System.out.printf("\t%-10s %-10s \n", postfixExp, S.printCharStack());
	 }
	 
	 return postfixExp;
 } // end convertToPostFix() method
 
 // returns a higher integer for a higher operator precedence 
 public static int precedence(char operator)
 {
	 switch(operator)
	 {
	 case '+': return 1;
	 case '*': return 2;
	 case '/': return 2;
	 case '(': return 3;
	 }
	
	 return 0;
 }// end precedence() method
}// end Project2 class

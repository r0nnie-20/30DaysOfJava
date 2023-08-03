
/*

Welcome to Data Structures and Algorith in Java!

2023/07/28
by Ronnie Cutamora

*/


//public class Data Structure Algorithm

import java.util.*;

public class DataStructuresAlgorithm{
	
	//main method
	public static void main(String[] args) {
	
	// stack = LIFO data structure. Last-in, first-out.
	// stores objects into a sort of "vertical tower"
	// push() to add an item to the top
	// pop() to remove an item from the top
		


	//creating a stack object
	Stack<String> stack = new Stack<String>();

	//pushing an item in stack
	stack.push("Minecraft");
	stack.push("Call of Duty Mobile");
	stack.push("Farlight 84");
	stack.push("Wildrift");
	

	//pop moethod - used to remove an item on top of the stack, returns an object "Wildrift"
	stack.pop();
		
		
	//displaying the stack on console
	System.out.println(stack);
	
	// Why use stack?
	// it is used to add undo/redo features in almost all software we use!
	// moving forward/backward through browser history	
	// backtracking algorithms (maze, file directories)	
	// calling functions (call stack)
	
	//2. Queue- FIFO data structure first in first out
	// collection designed for holding elements prior to processing
	//linear data structure

	//add enqueue offer()
	//remove dequeue poll()


	//creating a queque object
	Queue<String> queue = new LinkedList<String>();
	
	//add items to queue
	
	queue.offer("Jennie");
	queue.offer("Ruby");
	queue.offer("Jane");
	queue.offer("Nini");
	
	//remove the first item to queue
	queue.poll();
	System.out.println(queue);
	
	}

}

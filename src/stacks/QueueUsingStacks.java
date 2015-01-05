package stacks;

import java.util.Stack;

public class QueueUsingStacks {
	Stack<Integer> NewestStack = new Stack<Integer>();
	Stack<Integer> OldestStack = new Stack<Integer>();

	// adding in Queue
	public void enqueue(Integer n) {
		NewestStack.push(n);
	}

	// removing from queue
	public void dequeue() {
		shiftStacks(NewestStack);
		if (OldestStack.isEmpty() != true) {
			System.out.println(OldestStack.pop());	
		}

	}

	// shift stacks
	public void shiftStacks(Stack<Integer> newestStack) {
		//added to ensure that untill the oldest stack is not empty 
		if (OldestStack.isEmpty()) {
			while(newestStack.isEmpty()==false )
			OldestStack.push(newestStack.pop());
		}
	}
	

	public static void main(String[] args) {
		QueueUsingStacks queue = new QueueUsingStacks();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.dequeue();
		queue.enqueue(90);
		queue.enqueue(50);
		queue.dequeue();
	}
}
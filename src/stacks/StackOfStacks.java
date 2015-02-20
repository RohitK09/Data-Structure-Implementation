package stacks;

import java.util.ArrayList;
import java.util.LinkedList;

public class StackOfStacks {
	// array list of stacks
	private ArrayList<StackX> stackOfstacks = new ArrayList<StackX>();

	public StackX getLastStack() {

		return stackOfstacks.get(stackOfstacks.size() - 1);
	}

	public boolean push(long elem) {
		try {
			StackX stack = null;
			if (stackOfstacks.isEmpty()) {
				stack = new StackX(10);
				stack.Push(elem);
				stackOfstacks.add(stack);
			} else {
				StackX st = getLastStack();
				if (st.isFull()) {
					StackX newStack = new StackX(10);
					newStack.Push(elem);
					stackOfstacks.add(newStack);
				} else {
					st.Push(elem);
				}
			}
		} catch (Exception e) {

			return false;
		}
		return true;
	}

	public long pop() {
		long value = -1;
		try {
			StackX stack = getLastStack();
			value = stack.Pop();
			if (stack.isEmpty()) {
				stackOfstacks.remove(stack);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return value;
	}

	// to dispaly all stack and their elements ,it pops them off the stack
	public void display() throws Exception {
		int i = 1;
		for (StackX st : stackOfstacks) {

			System.out.println("Stack no" + i);

			while (st.isEmpty() != true) {

				long value = st.Pop();
				System.out.println(value);
			}
			i++;
		}
	}

	public long popAt(int i) throws Exception {
		long value;
		if (stackOfstacks.size() < i) {
			return -1;
		} else {

			value = stackOfstacks.get(i - 1).Pop();

		}
		return value;
	}

	public static void main(String[] args) {
		StackOfStacks stacks = new StackOfStacks();
		for (int i = 0; i < 150; i++) {
			// cast to long from double
			stacks.push((long) (Math.random() * 100));
		}
		

		/*
		 * for (int i = 0; i < 20; i++) { System.out.println(stacks.pop()); }
		 */

		System.out.println(stacks.stackOfstacks.size());
		try {
			System.out.println(stacks.popAt(4));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}

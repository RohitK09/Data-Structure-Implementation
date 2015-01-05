package stacks;

public class StackXChar {
	private int size;
	private int maxSize;
	private char[] stackArray;
	private int top = -1;

	public StackXChar(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void Push(char j) // push item on stack
	{
		stackArray[++top] = j; // top is incremented before insertion

	}

	public char Pop() throws Exception // popping out stack
	{
		return stackArray[top--];
	}

	private char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) {
		StackXChar stack = new StackXChar(10);
		try {
			stack.Push('R');
			stack.Push('0');
			stack.Push('H');
			stack.Push('I');
			stack.Push('T');
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			while (!stack.isEmpty()) {
				System.out.println(stack.isEmpty());
				char value = stack.Pop();

				System.out.println(value);
				System.out.println(" ");

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

package stacks;

public class AscendingOrderStack {
	StackX stack1 = new StackX(10);
	StackX stack2 = new StackX(10);

	public StackX SortStack() {
		try {
			
			while (stack1.isEmpty() == false) {
				long temp = stack1.Pop();
				while (stack2.isEmpty() == false && stack2.peek() > temp) {

					stack1.Push(stack2.Pop());
				}
				stack2.Push(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stack2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AscendingOrderStack as = new AscendingOrderStack();
		for (int i = 0; i < 10; i++) {
			// cast to long from double
			as.stack1.Push((long) (Math.random() * 100));
		}
		System.out.println(as.SortStack().peek());
		// as.stack1.Push(j);
		// as.SortStack().peek();

	}

}

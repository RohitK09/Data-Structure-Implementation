package stacks;

import java.util.Stack;

public class TowerOfHanoi {
	Stack<Integer> stacks ;
	private int index ;
	public TowerOfHanoi(int i){
		stacks = new Stack<Integer>();
		index = i ;
	}
	public void add(int elem){
		stacks.push(elem);
	}
	
	public void movefromTop(TowerOfHanoi t){
	int value = stacks.pop();
	t.add(value);
	}
	
	public void moveDisks(int n,TowerOfHanoi destination, TowerOfHanoi buffer){
	if(n>0)
		{
			moveDisks(n-1, buffer , destination);
			movefromTop(destination);
			buffer.moveDisks(n-1,destination,this);
		}
	}
	public static void main(String[] args) {
		int n = 3;
		TowerOfHanoi[] t = new TowerOfHanoi [3];
		for(int i = 0; i < n; i++ ){
			t[i] = new TowerOfHanoi(i);
		}
		for ( int i = n ; i >0 ; i--){
			t[0].add(i);
		}
		t[0].moveDisks(n,t[2],t[1]);
		while(t[2].stacks.isEmpty()!= true ){
			System.out.println(t[2].stacks.pop());
		}
	}

}
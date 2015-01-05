package stacks;

public class StackX
{
private int size ;
private int maxSize;
private Long[] stackArray ; 
private int top = -1 ;
private long min ;
public StackX(int s)
{	
	maxSize = s ;
	stackArray = new Long[maxSize];
	top=-1;	
}
public void Push(long j) //push item on stack
{
	if(top==-1){
		min = j;
	}else {
		if (stackArray[top]>j){
			min = j;
		}
	}
	stackArray[++top] = j; //top is incremented before insertion 
	
}
public long Pop() throws Exception //popping out stack 
{
	return stackArray[top--];
}
public long peek()
{
	return stackArray[top];
}
public boolean isEmpty()
{
 return(top==-1);
}
public boolean isFull(){
	//System.out.println("size"+top);
	return (top==maxSize-1);
}


public void findMin() 
{
 System.out.println(min);
}
public static void main(String[] args){
StackX stack = new StackX(10);
stack.Push(60);
stack.Push(20);
stack.Push(30);
stack.Push(40);

while(!stack.isEmpty())
{
System.out.println(stack.isEmpty());
try {
long value = stack.Pop();
}
catch(Exception exception){
	exception.printStackTrace();
}

System.out.println(" ");

}
stack.findMin();
}
}
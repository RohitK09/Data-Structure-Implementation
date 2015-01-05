package linkedList;

import java.util.HashSet;
import java.util.Stack;


	

public class node{
int value;
node next = null ;

public node(int d) {
	value = d;
}
public void addtoEnd(int d ){
	node end = new node(d);
	node n = this;
	while(n.next!=null){
		n = n.next;
	}
	n.next= end;
}
public node removeNode(node head, int e){
	
	node n = head;
	if(head.value ==e){
		return head.next;
	}
	
	while (n.next!=null){
		if(n.next.value == e)
		{
			n.next = n.next.next;
			return head;
		}
	 n= n.next;
	}
	
	return head;
}	

private void setNext(node oldNode,node newNode)
{
	oldNode.next = newNode ;
}
public node findAndremoveDuplicate(node head){
	node n = head;
	HashSet<Integer> uniqueNumbers = new HashSet<Integer>();
	node previous = null;
	while(n!=null){
		if(uniqueNumbers.contains(n.value)){
		previous.next = n.next;
			
		}
		else{
			uniqueNumbers.add(n.value);
			previous = n;
			
			}
		n=n.next;
	}
	return head;
	
}

public node findAndRemoveNodesWithoutTemp(node head)//without Temp buffer but O(n^2) {
{ if (head.next==null)
	 {
		 return head;
	 }
	 node current = head ;
	 while (current!=null){
	 node runner = current;
	 while(runner.next!=null){
	 if(runner.next.value == current.value){
		 runner.next = runner.next.next;
	 }
	 else{
		 runner = runner.next;
	 	}
	 }	 
	 current = current.next;
	 }
	 return head;
}
public void Display( node head){
	//check if its of length null
	
	if (head.next==null){
		System.out.println(head.value);
		return;
	}
	node n = head ;
	while(n.next!=null){
	System.out.println(n.value);	
	n = n.next;
	}
	if(n.next==null){
		System.out.println(n.value);
	}
}
//Q:Implement an algorithm to find the kth to last element of a singly linked list
public node extraxtFromKtoN(node head , int k){ //recursive o(1) space and o(n) time
	node firstcounter = head;
	node secondcounter = head;
	
	for (int i = 0 ; i< k-1;i++){
		if (secondcounter == null) return null; //error check
		secondcounter = secondcounter.next;
	}
	if (secondcounter==null)return null; //error check
	while(secondcounter.next!=null){
		
		secondcounter= secondcounter.next;
		firstcounter = firstcounter.next;
	}
	return firstcounter;
}
public node partitionAround(int val,node head){
	node startbeforelist = null ;
	node startafterlist = null;
	node endbeforelist = null;
	node endafterlist = null;
	node n = head ;
	if(head == null){
		return head;
	}
	while(n!=null){
		node next = n.next;
		n.next = null;
		if (n.value<val){
			if(startbeforelist == null)
			{
				startbeforelist = n;
				endbeforelist = startbeforelist;
				//System.out.println(n.value);
			}
			else{
				endbeforelist.next = n;
				//System.out.println(	startbeforelist.next.value);
				endbeforelist = n;
				//System.out.println(	endbeforelist.next.value);
			}
		}
		else{
			if(startafterlist == null)
			{
				startafterlist = n;
				endafterlist =startafterlist;
				//System.out.println("before "+n.value);
			}
			else{
				//System.out.println(endafterlist.value);
				endafterlist.next=n;
				endafterlist = n;
				String bd = new String();
				
				//System.out.println("before "+n.value);
			}
		}
	n = next;
	}
	if(startbeforelist == null){
		return startafterlist;
	}
	
	endbeforelist.next = startafterlist;
	return startbeforelist;
}

public void  findMiddleOfList( node head){
 node fastPtr = head;
 node slowPtr = head;
 if( head!=null){
	 while(fastPtr!= null && fastPtr.next!=null){
		 slowPtr = slowPtr.next;
		 fastPtr= fastPtr.next.next;
	 }
	 System.out.println(slowPtr.value);
 }
}
public void findNthNodefromLast(node head,int n){
	node fastPtr = head;
	node slowPtr = head;
	int i =0 ;
	while ( i < n)
	{
		fastPtr = fastPtr.next;
		i++;
	} 
	while(fastPtr!=null){
		slowPtr = slowPtr.next;
		fastPtr = fastPtr.next;
	}
	System.out.println(slowPtr.value);
}	
/*
 * adding two numbers
 */
private node addLinkLists(node n1,node n2 ,int carry)
{	int value = carry;
	node result = new node(carry);
	
	if(n1!=null){
		value +=n1.value ;
		
	}
	if(n2!= null){
		value +=n2.value;
	}
	
	result.value = value%10;
	
	if(n1!=null || n2!=null){
		node more = addLinkLists(n1==null?null:n1.next,n2==null?null:n2.next,value>10?1:0);
		result.setNext(result,more);
	}
	return result;
}
/*public addLinkListsDiffOrder(node firstNode,node secondNode, int carry ){
	int firstlen = findlengthNode(firstNode);
	int secondlen = findlengthNode(secondNode);
	int value = carry;
	node result = new node(value); 
	if(firstNode!=null){
		value +=firstNode.value;
	}
	
	if(secondNode!=null){
		value +=secondNode.value;
	}
	
	carry = value%10;
}*/
public void padWithZeroes(node nodeToFill,int padLength){
	
}
public int findlengthNode(node head){
	int i = 0;
	node tempNode = head;
	while(tempNode!=null){
		tempNode = tempNode.next;
		i++;
	}
	return i;
}

public boolean checkPalindromeOrNot(node nodeToCheck){
	Stack<Integer> stackOfNodes = new Stack<Integer>();
	node slowPtr = nodeToCheck;
	node fastPtr = nodeToCheck;
	while(fastPtr !=null && fastPtr.next!=null){
		stackOfNodes.push(slowPtr.value);
		slowPtr = slowPtr.next;
		fastPtr = fastPtr.next.next;
		
	}
	//skips the middle element if number of nodes is odd
	if(fastPtr!=null){
		slowPtr = slowPtr.next;
	}
	while(slowPtr!=null){
		if(slowPtr.value != stackOfNodes.pop().intValue() ){
			
			return false;
		}
		slowPtr = slowPtr.next;
		}
		return true;

}
public static void main(String[] args) {
	node n = new node(0);
	n.addtoEnd(5);
	n.addtoEnd(4);
	n.addtoEnd(6);
	n.addtoEnd(9);
	n.addtoEnd(7);
	//n.addtoEnd(8);
	//n.Display(n);
	//node n1 = n.removeNode(n, 4);
	//node n2 = n.findAndRemoveNodesWithoutTemp(n);
	//n.Display(n2);
	//node n3 = n.extraxtFromKtoN(n, 2);
	//n.Display(n3);
	//n.Display(n);
	//node n4 = n.partitionAround(6, n);
	//n.Display(n4);
	node n1 = new node(9);
	n1.addtoEnd(4);
	n1.addtoEnd(9);
	node n2 = new node(7);
	n2.addtoEnd(8);
	n2.addtoEnd(0);
	n.Display(n.addLinkLists(n1, n2, 0));
	//n.findMiddleOfList(n);
	//n.findNthNodefromLast(n,2);
	System.out.println(n.findlengthNode(n1));
	System.out.println(n.checkPalindromeOrNot(n1));
	
	
}
}

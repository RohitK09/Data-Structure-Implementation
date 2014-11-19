package linkedList;

import java.util.HashSet;


	

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
				endbeforelist = n;
				//System.out.println(n.value);
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
				//System.out.println(startafterlist.value);
				endafterlist.next=n;
				endafterlist = n;
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
public static void main(String[] args) {
	node n = new node(0);
	n.addtoEnd(5);
	n.addtoEnd(4);
	n.addtoEnd(6);
	n.addtoEnd(9);
	n.addtoEnd(7);
	n.addtoEnd(8);
	//n.Display(n);
	//node n1 = n.removeNode(n, 4);
	//node n2 = n.findAndRemoveNodesWithoutTemp(n);
	//n.Display(n2);
	//node n3 = n.extraxtFromKtoN(n, 2);
	//n.Display(n3);
	//n.Display(n);
	node n4 = n.partitionAround(6, n);
	n.Display(n4);
}
}

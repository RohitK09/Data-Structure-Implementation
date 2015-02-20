package linkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Node {
	Integer value = null;
	Node next = null;

	public Node(int d) {
		value = d;
	}

	public Node() {

	}

	public Node addtoFirst(int d) {
		if (this.value == null) {
			this.value = d;
			return this;
		} else {
			Node n = this;

			Node newStart = new Node(d);
			newStart.next = n;
			return newStart;
		}

	}

	public void addtoEnd(int d) {
		if (this.value == null) {
			this.value = d;
		} else {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
	}

	public Node removeNode(Node head, int e) {

		Node n = head;
		if (head.value == e) {
			return head.next;
		}

		while (n.next != null) {
			if (n.next.value == e) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}

		return head;
	}

	private void setNext(Node oldNode, Node newNode) {
		oldNode.next = newNode;
	}

	public Node findAndremoveDuplicate(Node head) {
		Node n = head;
		HashSet<Integer> uniqueNumbers = new HashSet<Integer>();
		Node previous = null;
		while (n != null) {
			if (uniqueNumbers.contains(n.value)) {
				previous.next = n.next;

			} else {
				uniqueNumbers.add(n.value);
				previous = n;

			}
			n = n.next;
		}
		return head;

	}

	public Node findAndRemoveNodesWithoutTemp(Node head)// without Temp buffer
														// but O(n^2) {
	{
		if (head.next == null) {
			return head;
		}
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.value == current.value) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		return head;
	}

	public void Display(Node head) {
		// check if its of length null

		if (head.next == null) {
			System.out.println(head.value);
			return;
		}
		Node n = head;
		while (n.next != null) {
			System.out.println(n.value);
			n = n.next;
		}
		if (n.next == null) {
			System.out.println(n.value);
		}
	}

	// Q:Implement an algorithm to find the kth to last element of a singly
	// linked list
	public Node extraxtFromKtoN(Node head, int k) { // recursive o(1) space and
													// o(n) time
		Node firstcounter = head;
		Node secondcounter = head;

		for (int i = 0; i < k - 1; i++) {
			if (secondcounter == null)
				return null; // error check
			secondcounter = secondcounter.next;
		}
		if (secondcounter == null)
			return null; // error check
		while (secondcounter.next != null) {

			secondcounter = secondcounter.next;
			firstcounter = firstcounter.next;
		}
		return firstcounter;
	}

	public Node partitionAround(int val, Node head) {
		Node startbeforelist = null;
		Node startafterlist = null;
		Node endbeforelist = null;
		Node endafterlist = null;
		Node n = head;
		if (head == null) {
			return head;
		}
		while (n != null) {
			Node next = n.next;
			n.next = null;
			if (n.value < val) {
				if (startbeforelist == null) {
					startbeforelist = n;
					endbeforelist = startbeforelist;
					// System.out.println(n.value);
				} else {
					endbeforelist.next = n;
					// System.out.println( startbeforelist.next.value);
					endbeforelist = n;
					// System.out.println( endbeforelist.next.value);
				}
			} else {
				if (startafterlist == null) {
					startafterlist = n;
					endafterlist = startafterlist;
					// System.out.println("before "+n.value);
				} else {
					// System.out.println(endafterlist.value);
					endafterlist.next = n;
					endafterlist = n;
					String bd = new String();

					// System.out.println("before "+n.value);
				}
			}
			n = next;
		}
		if (startbeforelist == null) {
			return startafterlist;
		}

		endbeforelist.next = startafterlist;
		return startbeforelist;
	}

	public void findMiddleOfList(Node head) {
		Node fastPtr = head;
		Node slowPtr = head;
		if (head != null) {
			while (fastPtr != null && fastPtr.next != null) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next.next;
			}
			System.out.println(slowPtr.value);
		}
	}

	public void findNthNodefromLast(Node head, int n) {
		Node fastPtr = head;
		Node slowPtr = head;
		int i = 0;
		while (i < n) {
			fastPtr = fastPtr.next;
			i++;
		}
		while (fastPtr != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		System.out.println(slowPtr.value);
	}

	/*
	 * adding two numbers
	 */
	private Node addLinkLists(Node n1, Node n2, int carry) {
		int value = carry;
		Node result = new Node(carry);

		if (n1 != null) {
			value += n1.value;

		}
		if (n2 != null) {
			value += n2.value;
		}

		result.value = value % 10;

		if (n1 != null || n2 != null) {
			Node more = addLinkLists(n1 == null ? null : n1.next,
					n2 == null ? null : n2.next, value > 10 ? 1 : 0);
			result.setNext(result, more);
		}
		return result;
	}

	/*
	 * public addLinkListsDiffOrder(node firstNode,node secondNode, int carry ){
	 * int firstlen = findlengthNode(firstNode); int secondlen =
	 * findlengthNode(secondNode); int value = carry; node result = new
	 * node(value); if(firstNode!=null){ value +=firstNode.value; }
	 * 
	 * if(secondNode!=null){ value +=secondNode.value; }
	 * 
	 * carry = value%10; }
	 */
	public void padWithZeroes(Node nodeToFill, int padLength) {

	}

	public int findlengthNode(Node head) {
		int i = 0;
		Node tempNode = head;
		while (tempNode != null) {
			tempNode = tempNode.next;
			i++;
		}
		return i;
	}

	public boolean checkPalindromeOrNot(Node nodeToCheck) {
		Stack<Integer> stackOfNodes = new Stack<Integer>();
		Node slowPtr = nodeToCheck;
		Node fastPtr = nodeToCheck;
		while (fastPtr != null && fastPtr.next != null) {
			stackOfNodes.push(slowPtr.value);
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

		}
		// skips the middle element if number of nodes is odd
		if (fastPtr != null) {
			slowPtr = slowPtr.next;
		}
		while (slowPtr != null) {
			if (slowPtr.value != stackOfNodes.pop().intValue()) {

				return false;
			}
			slowPtr = slowPtr.next;
		}
		return true;

	}

	public void addAndremoveAltNode(Node head) {
		Node Oddnode = new Node();
		Node node = head;
		while (node != null && node.next != null) {

			Oddnode.addtoEnd(node.value);
			
				node = node.next.next;
			

		}
		/*
		 * if(node.next==null){ Oddnode.addtoEnd(node.value);
		 * 
		 * }
		 */
		head = head.next;
		while (head != null && head.next != null) {
			Oddnode.addtoEnd(head.value);
			head = head.next.next;
		}

		while (Oddnode != null) {
			System.out.println(Oddnode.value);
			Oddnode = Oddnode.next;
		}

	}
	public void findMaxSubArray(Integer[] integers)
	{
		int max_so_far = 0;
		int max_ending =0;
		int max_non_cont=0;
		max_non_cont =integers[0];
		max_so_far = integers[0];
		max_non_cont = 0;
		for(int i = 0; i<integers.length ; i++){
			 max_ending = max(integers[i],integers[i]+max_ending);
			 max_so_far = max(max_ending,max_so_far );
			if(integers[i]>0){
			 max_non_cont = max(max_non_cont,integers[i]+max_non_cont);
			}else if (integers[i]<0 &&integers[i]>max_non_cont) 
			{
				max_non_cont=integers[i];
			}
		}
		for(int i = 1; i<integers.length ; i++){
			
			if(integers[i]>0){
				max_non_cont = max(max_non_cont,integers[i]+max_non_cont);
			}else if (integers[i]<0 &&integers[i]>max_non_cont) 
			{
				max_non_cont=integers[i];
			}
		}
		
		System.out.print(max_so_far +"\t"+max_non_cont);
	}
	public int max(int x, int y)
	{
		return (y>x?y:x);
	}
	public static void main(String[] args) {
		Node n = new Node(0);
		n.addtoEnd(5);
		n.addtoEnd(4);
		n.addtoEnd(6);
		n.addtoEnd(9);
		n.addtoEnd(7);

		// n.addtoEnd(8);
		// n.Display(n);
		// node n1 = n.removeNode(n, 4);
		// node n2 = n.findAndRemoveNodesWithoutTemp(n);
		// n.Display(n2);
		// node n3 = n.extraxtFromKtoN(n, 2);
		// n.Display(n3);
		// n.Display(n);
		// node n4 = n.partitionAround(6, n);
		// n.Display(n4);
		Node n1 = new Node(9);
		n1.addtoEnd(4);
		n1.addtoEnd(9);
		Node n2 = new Node(7);
		n2.addtoEnd(8);
		n2.addtoEnd(0);
		n.Display(n.addLinkLists(n1, n2, 0));
		// n.findMiddleOfList(n);
		// n.findNthNodefromLast(n,2);
		System.out.println(n.findlengthNode(n1));
		System.out.println(n.checkPalindromeOrNot(n1));
		Node chkNode = new Node(1);
		chkNode.addtoEnd(2);
		chkNode.addtoEnd(3);
		chkNode.addtoEnd(4);
		chkNode.addtoEnd(5);
		chkNode.addtoEnd(6);
		chkNode.addtoEnd(7);
		chkNode.addtoEnd(8);
		chkNode.addtoEnd(9);
		chkNode.addtoEnd(10);
		n.addAndremoveAltNode(chkNode);
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		ArrayList<Integer[]> noOfArray = new ArrayList<Integer[]>()  ;
		for(int j =0;j<noOfTestCases;j++)
		{	
			int len = in.nextInt();
			Integer[] arr2 = new Integer[len];
			for(int i =0; i<len; i++ )
				{
					arr2[i] = in.nextInt();
 				}
			for(int i =0;i< arr2.length;i++)
			{
				System.out.println(arr2[i]);
			}
			noOfArray.add(arr2);
		}
		for (int j =0;j<noOfArray.size();j++)
		{
			n.findMaxSubArray(noOfArray.get(j));
		}
		System.out.println();
		Integer[] arr = {1,2,5,7,-1,2,0};
		n.findMaxSubArray(arr);
	}
	
}

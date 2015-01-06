package graph;

import java.io.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import linkedList.Node;

public class DFS {
	ArrayList<Node> AdjancencyList  = new ArrayList<Node>(); 
	
	public static void main(String[] args){
		
		 ArrayList<Node> AdjancencyList  = new ArrayList<Node>(); 
		 Scanner in = new Scanner(System.in);
		 
	      System.out.println("Enter a noOfNodesIn Graph");
	      Integer noOfGraph = Integer.valueOf(in.nextLine());
	      
	      System.out.println("You entered nodes "+noOfGraph);
		 
	      for(int i =0 ; i<noOfGraph;i++){
	    	  AdjancencyList.add(new Node(i));
	      }
		 AdjancencyList.get(0).addtoEnd(1);
		 AdjancencyList.get(0).addtoEnd(2);
		 
		 AdjancencyList.get(1).addtoEnd(3);
		 
		 AdjancencyList.get(2).addtoEnd(3);
		 
		 AdjancencyList.get(3).addtoEnd(4);
		 
		 
}
}
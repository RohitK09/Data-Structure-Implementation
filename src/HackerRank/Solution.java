package HackerRank;


import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		long  l = 2147483647;
		long l1 =1;
		
		 Scanner in = new Scanner(System.in); 
         int noOfInputs = in.nextInt();
         long[] arrayOfNumbers = new long[noOfInputs]; 
        for(int i = 0 ; i<noOfInputs;i++){
            arrayOfNumbers[i]= in.nextLong();
           }
        for(int i = 0 ; i<noOfInputs;i++){
        	
        	//System.out.println(l);
        	System.out.println((~ arrayOfNumbers[i]&((l1<<32)-1)));
            	}
         
            }
            
        }
	

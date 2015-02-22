package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class XORing {
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in); 
	         //int noOfInputs = in.nextInt(); 
		 int i = 0;
	    	 String str1 = in.nextLine();
		String str2 = in.nextLine();
		int[] arrayOfch = new int[91];
	 	for (char ch:str1.toCharArray()){
			
	 		//arrayOfch. = arrayOfch[ch]+1;
		}
		for (char ch1:str2.toCharArray()){
			if(arrayOfch[ch1]>0){
			 i++;
			 arrayOfch[ch1] = arrayOfch[ch1] - 1;
			}		
			
		}
		System.out.println(i);
	    	
	}
}

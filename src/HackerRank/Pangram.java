package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class Pangram {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in); 
    String str = in.nextLine();
 
      
     ArrayList<Integer> listOfChar = new ArrayList<Integer>();
     for(char ch : str.toLowerCase().toCharArray()){
		if (ch ==' ')
		{
		
		}
		if( listOfChar.contains((int)ch)==false & (int)ch >=97&(int)ch<=122)
		{
			listOfChar.add((int) ch);
		}
		
	}
	if(listOfChar.size()>26 || listOfChar.size()<26 )
	{	
	  System.out.println("not pangram");
	}
	else{
		System.out.println("pangram");
	}
	}

}


package arrays;

/*
 * Q Given an Array A[] and a number x , determine whether or not there exists two 
 * elements in where sum is actually x.
 */
import java.util.Arrays;

public class PairFind {
	
	public void findPair(int[] arrayOfInts, int x){
		Arrays.sort(arrayOfInts); //sort the array 
		int len = arrayOfInts.length;
		if( len == 1 )
		{
		System.out.println("only one element");
		
		}
		else {
			int firstIndex = 0;
			int lastIndex = len-1;
			while (firstIndex<lastIndex)
			
			{
				
			if( arrayOfInts[firstIndex]+arrayOfInts[lastIndex]== x){
				System.out.println(arrayOfInts[firstIndex]+","+arrayOfInts[lastIndex]);
				System.exit(0);
				}
			else if (arrayOfInts[firstIndex]+arrayOfInts[lastIndex]> x){
				lastIndex--;
				
			}
			else if(arrayOfInts[firstIndex]+arrayOfInts[lastIndex]<x){
				firstIndex++;
				
			}
			}
			}
		
	}
			
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairFind pf = new PairFind();
		int[] arrayOfNumber ={1,7,4,3,2};
		pf.findPair(arrayOfNumber, 3);
	}

}

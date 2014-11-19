package arrays;

import java.io.*;
public class CandidateCode 
{ 
    public static int[] getMaximumToysWithMaxSaving(int input1,int[] input2)
    {
    	int [] finalresult = new int[2] ;
        int length = input2.length;
      // int[] inputOutPut = {0,0} ;
        int totalCount = 0 ;
        int totalSum = 0 ;
       
        /*for(int j =0;j<length;j++)
        {
        	/if (input1<input2[j])
        	{
        		
        		input2[j] = 0 ;
        		
        	}
        	else
        	{
        		
        	}
        	
        }*/
       // System.out.println(input2[3]);
        int j = 0;
        int temp =0; 
        int highestSum = 0;
        for (int i =0 ;i<input2.length ;i++)
        {
        	if(input2[i]!=0){
        	int min = new CandidateCode().findMin(input2);
        	System.out.println(min);
        	totalSum=+min;
        	input2[min] = 0 ;
        	
        	if (totalSum>input1){
        		
        		break;
        	}
        	
        		finalresult[0]=input1-totalSum;
        	
        	
        }
       }
        
    return finalresult;
    }
    public int findMin(int [] a){
    	int temp = 0;
    	
    	for (int i =0;i<a.length-1; i++){
    		if(a[i]>0 && temp ==0)
    		{
    			temp = a[i];
    			System.out.println(temp);
    		}
    		
    			
    			
    			if(temp >a[i])
    			{
    				
    				temp = a[i];
    				a[i]=temp;
    				System.out.println("temp"+temp);
    			}
    			
    		
    		
    	}
    	
    	return temp ; 
    }
public static void main(String[] args) {
	int [] test = {1,12,15,70,112,8,53,6,7,67} ;
	int [] op = getMaximumToysWithMaxSaving(60, test);
	System.out.println(op[0]+"hj"+ op[1]);
	
} 

}

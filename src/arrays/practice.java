package arrays;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class practice {

	public int findMin(int x, int y) {
		return ((x < y) ? x : y);
	}

	public int findMax(int x, int y) {
		return ((x > y) ? x : y);
	}

	int max_len = 1;

	// For Distinct Integers
	public int findContinuous(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int mn = arr[i];
			int mx = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				mn = findMin(mn, arr[j]);
				mx = findMax(mx, arr[j]);
				if ((mx - mn) == (j - i)) {
					max_len = findMax(max_len, mx - mn + 1);
				}
			}

		}
		return max_len;

	}

	// For Distinct Integers
	public int findContinuousInt(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			HashSet<Integer> set = new HashSet<Integer>();

			int mn = arr[i];
			int mx = arr[i];
			set.add(arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				if (set.contains(arr[j]))
					break;

				set.add(arr[j]);
				mn = findMin(mn, arr[j]);
				mx = findMax(mx, arr[j]);
				if ((mx - mn) == (j - i)) {
					max_len = findMax(max_len, (mx - mn) + 1);
				}

			}

		}
		return max_len;

	}

	static int findLength(int arr[]) {
		int n = arr.length;
		int max_len = 1; // Inialize result

		// One by one fix the starting points
		for (int i = 0; i < n - 1; i++) {
			// Create an empty hash set and add i'th element
			// to it.
			HashSet<Integer> set = new HashSet<>();
			set.add(arr[i]);

			// Initialize max and min in current subarray
			int mn = arr[i], mx = arr[i];

			// One by one fix ending points
			for (int j = i + 1; j < n; j++) {
				// If current element is already in hash set, then
				// this subarray cannot contain contiguous elements
				if (set.contains(arr[j]))
					break;

				// Else add curremt element to hash set and update
				// min, max if required.
				set.add(arr[j]);
				mn = Math.min(mn, arr[j]);
				mx = Math.max(mx, arr[j]);

				// We have already cheched for duplicates, now check
				// for other property and update max_len if needed
				if (mx - mn == j - i)
					max_len = Math.max(max_len, mx - mn + 1);
			}
		}
		return max_len; // Return result
	}

	public void findTheMaxAndMin(int noOfCases, int[] number) {
		for (int i = 0; i < noOfCases; i++) {
			List<Integer> st = new ArrayList<Integer>();
			List<Integer> strev = new ArrayList<Integer>();
			while (number[i] > 0) {
				System.out.println(number[i] % 10);
				st.add(number[i] % 10);
				number[i] = number[i] / 10;
			}
			while (number[i] > 0) {
				System.out.println(number[i] % 10);
				strev.add(number[i] % 10);
				number[i] = number[i] / 10;
			}
			int n = st.size();
			System.out.print("Case #" + (i + 1) + ":");
			int temp = 0;
			
			//strev = st;
			Collections.sort(st);
		    Collections.sort(strev,Collections.reverseOrder());
			
			for (int k : st) {
				if (temp > 0) {
					System.out.print("0");
					temp--;
				}
				if (k == 0) {
					temp++;
				}else{
				System.out.print(k);
				}
		}
			System.out.print(" ");
			for (int l : strev) {
				if (temp > 0) {
					System.out.print("0");
					temp--;
				}
				if (l == 0) {
					temp++;
				}else{
				System.out.print(l);
				}
		}
		}
		
	}
	public static int find_MaxContiguous(int[] arr)
	{
		int max_sum_sofar =0;
		int max_last =0;
	 	for(int i =0;i<arr.length;i++)
		{	max_last =max_last+arr[i]; 
			if(max_last<0)
			{	
			  	max_last = 0;
			}
			
		if(max_last >max_sum_sofar)
			{
					max_sum_sofar = max_last ;
			}	
		}
	return max_sum_sofar;

	}
	public static int find_missing_number( int [] arr)
	{
		int X1 =1; 
		int X2 = arr[0];
		int n= arr.length;
		for(int i =2;i<=n+1;i++)
		{
			X1=X1^i;	
		}
		for(int j=1;j<n;j++)
		{
			X2= X2^arr[j];	 	
		}
		//int missing_number = ;
		return X1^X2;
	}
	//move m places;
	public static int[] moveMPlaces(int[] arr, int m)
	{
		int j =m-1;
		for( int i =m-1;i>=0;i--)
		{
			if(arr[i]!=-1)
			{
				arr[j] = arr[i];
				//arr[i]=0;
				j--;
			}
			
		}
		
	return arr;
	}
	public static  int[] merge(int [] MplusN ,int[] N,int m,int n)
	{	
		int i =n; //pointer for input part of MplusN
		int j = 0; //pointer for N
		int k = 0; //pointer for mplusn from starting
	 while(k<m+n){
		 if( i<m+n && MplusN[i]<N[j]||j==n){
			 MplusN[k] = MplusN[i];
			 k++;
			 i++;
		 }
		 else
		 {
			 MplusN[k] = N[j];
			 k++;
			 j++;
		 }
		 
	 
	 }
		return MplusN;
		
	}
	public static int[] reverseAnArray(int[] arr)
	{
		int start = 0;
		int end = arr.length-1;
		int temp;
		while(start<end)
		{   temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}
	//o(n)
	public static void findSmallestsecondSmallest(int [] arr)
	{
		int smallest = Integer.MAX_VALUE; 
		int second_smallest = Integer.MAX_VALUE;
		if(arr.length<2)
		{
			System.out.println("a");
		}
		for(int i : arr)
		{	if(i <smallest)
			{
			second_smallest = smallest;	
			smallest = i;
			
			}
		else if(i >smallest&& i<second_smallest)
		{
			second_smallest = i;
		}
		}
		System.out.println("smallest" + smallest +"second Smallest:"+second_smallest);
	}
	public static int[] reverseAnArrayByRotation(int[] arr,int d)
	{
		int start = 0;
		int end = arr.length-1;
		int temp;
		int count = 0;
		while(start<end)
		{   temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
			count++;
			if(count ==d)
			{
				break;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] b = { -1, -6, -2, 7, -7, 8 };
		int [] c = {1,2,3,5};
		/*System.out.println("the conitnuous numbers in array are +"
				+ findLength(b));*/
		int number = 67;
		Scanner in = new Scanner(System.in);
		//int noOfInputs = in.nextInt();
		//int[] n = new int[noOfInputs];
		//for (int i = 0; i < noOfInputs; i++) {
			//n[i] = in.nextInt();
		//}
		//new practice().findTheMaxAndMin(noOfInputs, n);
		//System.out.println(find_MaxContiguous(b));
		//System.out.println(find_missing_number(c));
		int NA = -1;
		int[] mPlusN = {2, 8, NA, NA, NA, 13, NA, 15, 20};
		int [] N = {5, 7, 9, 25};
		int m=mPlusN.length-N.length;
		for (int i: merge(moveMPlaces(mPlusN,mPlusN.length), N,m,N.length))
		{
			//System.out.println(i);
		}
		int[] n = {'a','b','c','d','e','f'};
		for(int i : reverseAnArrayByRotation(n, 4))
		{
			System.out.println(i);
		}
		findSmallestsecondSmallest(n);
	}
}

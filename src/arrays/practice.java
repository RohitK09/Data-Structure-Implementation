package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class practice {

	public int findMin(int x, int y){
		return ((x<y)?x:y);
	}
	public int findMax(int x, int y){
		return ((x>y)?x:y);
	}
	int max_len = 1;
	
	//For Distinct Integers
	public int findContinuous (int[] arr){
		
		for (int i =0;i<arr.length-1;i++){
			int mn = arr[i]; 
			int mx = arr[i];
			for ( int j = i+1; j<arr.length;j++){
				mn = findMin(mn,arr[j] );
				mx = findMax(mx,arr[j]);
			if((mx-mn) ==(j-i)  ){
				max_len = findMax(max_len,mx-mn+1 );
			}
			}
			
		}
		return max_len;
	
	}
	//For Distinct Integers
		public int findContinuousInt (int[] arr){
			
			
			for (int i =0;i<arr.length-1;i++){
				HashSet<Integer> set = new HashSet<Integer>();
				
				int mn = arr[i]; 
				int mx = arr[i];
				set.add(arr[i]);
				for ( int j = i+1; j<arr.length;j++){
					if(set.contains(arr[j]))
						break;
					
					set.add(arr[j]);
					mn = findMin(mn,arr[j] );
					mx = findMax(mx,arr[j]);
				if((mx-mn) ==(j-i)){
					max_len = findMax(max_len,(mx-mn)+1 );
				}
				
					
				}
				
			}
			return max_len;
		
		}
		static int findLength(int arr[])
	    {
	        int n = arr.length;
	        int max_len = 1; // Inialize result
	 
	        // One by one fix the starting points
	        for (int i=0; i<n-1; i++)
	        {
	            // Create an empty hash set and add i'th element
	            // to it.
	            HashSet<Integer> set = new HashSet<>();
	            set.add(arr[i]);
	 
	            // Initialize max and min in current subarray
	            int mn = arr[i], mx = arr[i];
	 
	            // One by one fix ending points
	            for (int j=i+1; j<n; j++)
	            {
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
	                if (mx-mn == j-i)
	                    max_len = Math.max(max_len, mx-mn+1);
	            }
	        }
	        return max_len; // Return result
	    }
	public static void main(String[] args) {
		int [] b = {1,6,2,7,7,8};
		System.out.println("the conitnuous numbers in array are +" + findLength(b));
	}
}

package com.dynamicProblems;

public class CountWays {

	// Inefficient implementation O(3^n)
	public int countNoOfWays(int x) {
		if (x < 0) {
			return 0;
		} else if (x == 0) {
			return 1; // base case
		}

		return (countNoOfWays(x - 1) + countNoOfWays(x - 2) + countNoOfWays(x - 3));

	}
	/*
	 *  (O(n) implementation, we are saving the intermediate results in cache so that )
	 *   no of steps from say a X step is not counted twice.
	 */
	
	public int countNoOfWays(int x, int[] cache) {
		if (x < 0) {
			return 0;
		}
		else if (x == 0) {
			return 1;
		}
		else if (cache[x] > -1) {
			return cache[x];
		}
		else
		{
			cache[x] = (countNoOfWays(x - 1) + countNoOfWays(x - 2) + countNoOfWays(x - 3));
			return cache[x];
		}
	}

	public static void main(String[] args) {
		CountWays countWays = new CountWays();
		int[] cache = new int[100];
		System.out.println(countWays.countNoOfWays(4));
	}
}

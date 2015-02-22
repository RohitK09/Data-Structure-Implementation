package com.dynamicProblems;

public class MagicNumber {
	public int findMagicNumberDistinct(int[] magicArray, int start, int end) {
		//borderline cases
		if(start>end || end> magicArray.length||magicArray.length<0 )
		{
			return -1;
		}		
		int mid = (start + end) / 2;

		if ((mid) == magicArray[mid]) {
			return mid;

		} else if (mid > magicArray[mid]) {
			return findMagicNumberDistinct(magicArray, mid + 1, end);
		} else  {
			return findMagicNumberDistinct(magicArray, start, mid - 1);
		}

	}

	public static void main(String[] args) {
		MagicNumber m = new MagicNumber();
		int[] arr = { -2, -1, 2, 4, 6, 8, 9 };
		System.out.println(m.findMagicNumberDistinct(arr, 0, arr.length - 1));
	}
}

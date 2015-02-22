package com.dynamicProblems;

import java.util.ArrayList;

public class AllSubSets {
	public ArrayList<ArrayList<Integer>> findAllSubsets(ArrayList<Integer> set , int index)

	{	
		//Base case , will add empty set here
		
		if(set.size() == index)
		{
		ArrayList<ArrayList<Integer>> allsubset = new ArrayList<ArrayList<Integer>>()	;
		allsubset.add(new ArrayList<Integer>());  
		return allsubset;
		}
		else
		{
		 int elem = set.get(index);
		 ArrayList<ArrayList<Integer>> allsubset = findAllSubsets(set , index+1);			
		ArrayList<ArrayList<Integer>> moresubset = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> i  : allsubset)
			{
			  ArrayList<Integer> newsubset = new ArrayList<Integer>();
			  newsubset.addAll(i);
			  newsubset.add(elem);
			  moresubset.add(newsubset);		
			}
		 allsubset.addAll(moresubset);		
		 return allsubset;
		}
		




	}
	public static void main(String[] args) {
		AllSubSets set = new AllSubSets();
		ArrayList<Integer> setOfInts = new ArrayList<Integer> ();
		for(int i = 0; i<5; i++)
		{
			setOfInts.add(i);
		}
		for(ArrayList<Integer> test :  set.findAllSubsets(setOfInts, 0))
		{
			System.out.println(test);
		}
	}
}

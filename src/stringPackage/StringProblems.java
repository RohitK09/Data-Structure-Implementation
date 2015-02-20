package stringPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class StringProblems {

	public void replaceInCharArray(char[] str) {

		int len = str.length;
		int ExtraLength = 0;
		int newLength = 0;
		char[] newStr = null;
		for (int i = 0; i < len; i++) {
			if (str[i] == ' ') {
				ExtraLength++; // getting the length of spaces

			}
		}
		newLength = len + ExtraLength * 2;
		newStr = new char[newLength];
		System.out.println("***" + newLength);// new length of the
												// String-Character Array

		for (int i = len - 1; i > -1; i--) {
			if (str[i] == ' ') {
				newStr[newLength - 1] = '0';
				newStr[newLength - 2] = '2';
				newStr[newLength - 3] = '%';
				newLength = newLength - 3;

			} else {
				newStr[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		System.out.println(newStr);
	}

	public boolean checkForRotation(String s1, String s2) {
		// check for lengths
		if (s1.length() == s2.length()) {
			StringBuilder sb = new StringBuilder(s1);
			sb.append(s1);
			if (sb.toString().contains(s2)) {
				return true;
			}
		}
		return false;
	}

	public String UniqueOrNot(String str) {
		char[] chOfStrings = str.toLowerCase().toCharArray();
		HashMap<Character, Boolean> listOfCh = new HashMap<Character, Boolean>();
		for (char ch : chOfStrings) {
			if (listOfCh.get(ch) == null) {
				listOfCh.put(ch, true);
			} else if (listOfCh.get(ch) == true) {
				return "not unique ";
			}

		}
		return "Unique";

	}

	public String UniqueOrNotWithoutExtraDS(String str) {

		char[] chOfStrings = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			char ch = chOfStrings[i];
			for (int j = i + 1; j < str.length(); j++) {
				if (ch == chOfStrings[j]) {
					return "not Unique";
				}
			}
		}
		return "Unique";
	}

	public String isUniqueOrNotWithoutUsingExtraDS(String str) {
		if (str.length() > 256) {
			return "not Unique";
		}
		boolean[] charSet = new boolean[256];

		char[] listOfCh = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			int value = str.charAt(i);
			if (charSet[value] == true) {
				return "Not Unique";
			} else {
				charSet[value] = true;
			}

		}
		return "unique";
	}

	public boolean permutationOrNot(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}

		int[] strCount = new int[256];
		for (char ch : str1.toCharArray()) {
			strCount[ch]++;
		}
		for (char ch : str2.toCharArray()) {
			strCount[ch]--;
			if (strCount[ch] < 0) {
				return false;
			}
		}

		return true;
	}

	public char[] replaceSpaceWith20(char[] str, int length) {

		int extraLen = 0;
		for (char ch : str) {
			if (ch == ' ') {
				extraLen++;
			}
		}
		int newLength = length + extraLen * 2;
		str[newLength] = '\0';
		for (int i = length - 1; i > 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return str;
	}
	public static boolean isRotationOrNot(String str1,String str2)
	{
		if (str1.length()!=str2.length())
		{
			return false;
		}
		else
		{
			String s1s1 = str1+str1;
			if(s1s1.contains(str2))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	public static String removeVowelsInAString(String str) {
		ArrayList<Character> vowelList = new ArrayList<Character>();
		vowelList.add('a');
		vowelList.add('e');
		vowelList.add('i');
		vowelList.add('o');
		vowelList.add('u');
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toLowerCase().toCharArray()) {
			if (vowelList.contains(ch) == false) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	public static String removeVowels (String str)
	{ 
		HashSet <Character> setOfVowels = new HashSet<Character>();
		StringBuilder strbuild = new StringBuilder();
		setOfVowels.add('a');
		setOfVowels.add('e');
		setOfVowels.add('i');
		setOfVowels.add('o');
		setOfVowels.add('u');
		for(int i=0;i<str.length();i++)
		{
			if(!setOfVowels.contains(str.charAt(i))){
				strbuild.append(str.charAt(i));
			}
		}
		return strbuild.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new StringProblems().replaceInCharArray("Hello String Replace"
				.toCharArray());
		System.out.println(new StringProblems().checkForRotation(new String(),
				new String()));
		System.out.println(new StringProblems()
				.isUniqueOrNotWithoutUsingExtraDS("lootera"));
		System.out.println(new StringProblems()
				.isUniqueOrNotWithoutUsingExtraDS("lootera"));
		System.out.println(new StringProblems().permutationOrNot("lootera",
				"raloote"));
		// System.out.println(new
		// StringProblems().permutationOrNot("lootera",null)); //fails in this
		// case
		ArrayList<Integer> raylist = new ArrayList<Integer>();

		long l = 2147483647;
		long l1 = 1;
		System.out.println((~l & ((l1 << 32) - 1)));
		char[] ch = new char[50];
		for (int i = 0; i < "Hello String Replace".length(); i++) {
			ch[i] = "Hello String Replace".charAt(i);
		}
		System.out.println(new StringProblems().replaceSpaceWith20(ch,
				"Hello String Replace".length()));
		System.out.println(removeVowels("rohit"));
		System.out.println(isRotationOrNot("rohit","tiroh"));
	}

}

package stringPackage;

public class Palidrome {

	public static void main(String[] args) {
		istPalindrom(new String("Hello").toCharArray());
		// TODO Auto-generated method stub

	}
	public static boolean istPalindrom(char[] word){
	    int i1 = 0;
	    int i2 = word.length - 1;
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            word[i1]=' ';
	        }
	        System.out.println(word);
	        ++i1;
	        --i2;
	    }
	    return true;
	}
}

/**
 * 
 */
/**
 * @author Rohit Katyal
 *
 */
package recursion;

public class Factorial{
	
	public static int getfactorial(int n){
		
		if (n == 0)
		{
			return 1;
		}
		else 
		{
			return n * getfactorial(n-1);
		}
	}
public static int getfibbonaci(int n){
		
		if (n == 0)
		{
			return 0;
		}
		else 
		{
			return n + getfibbonaci(n-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(getfactorial(6));
		int i = 0;
		String str = new String("ABCD");
		System.out.println("" + str.charAt(i));
		System.out.println(str.substring(0, i)) ;
		System.out.println(getfibbonaci(4));
	}
}
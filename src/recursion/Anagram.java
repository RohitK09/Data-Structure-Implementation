package recursion;

public class Anagram {

	public void  permutation(String prefix,String str){
		int n = str.length();
		if(n==0 ){
			System.out.println(prefix);
		}
		else {
			for(int i = 0 ; i<n; i++){
			permutation(prefix + str.charAt(i), str.substring(0,i)+ str.substring(i+1));
			System.out.println("prefix"+prefix);
			System.out.println("str"+str);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagram an = new Anagram();
		an.permutation(" ", "ABCD");
	}

}

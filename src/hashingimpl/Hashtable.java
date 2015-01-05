package hashingimpl;

public class Hashtable {

	public static void main(String[] args) {
		
		hashFunction(21);
	 //   System.out.println( h ^ (h>>> 7) ^ (h>>> 4);

	}
	private static void hashFunction(int h){
		System.out.println((h % 16));
	}
}

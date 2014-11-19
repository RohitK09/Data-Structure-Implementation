package bitshift;

public class BitShift {
	

	public static void main(String[] args) {
		int a = -1000000 ;
		int b = 2 ;
		int c = 4;
		System.out.println("xor" + (b^c));
		
		System.out.println((~a));
		System.out.println((a<<1)); // shifting byte one place left and each place we shift its multiplied by 2 
		System.out.println((a<<2))	;	
		System.out.println((a>>>2));
		System.out.println((a>>2));//preserves the sign , pads with the most significant Bit.
		
	}

}

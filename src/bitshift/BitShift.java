package bitshift;

public class BitShift {

	public int ChkGrayCode(byte G1, byte G2) {
		// System.out.println(Integer.toBinaryString(G1));
		// System.out.println(Integer.toBinaryString(G2) + "***");
		// System.out.println(Integer.toBinaryString(2));
		// System.out.println(Integer.toBinaryString(5));
		// System.out.println(Integer.toBinaryString(5&((1<<5)-1)));
		// byte i =(byte) 0b10101111;
		// System.out.println("***"+Byte.((byte) (i^i>>>1)));
		// System.out.println(Integer.toBinaryString((1<<12)-1));
		int mask = ((1 << 8) - 1);
		System.out.println(Integer.toBinaryString(mask));
		int resultInt = ((G1 & mask ^ G2 & mask));
		System.out.println(resultInt);
		String result = Integer.toBinaryString(resultInt);
		System.out.println(result);
		int res = 0;

		for (int k = result.length() - 1; k > -1; k--) {

			if (result.charAt(k) == '1') {
				res++;
			}
			if (res > 1) {
				return -1;

			}

		}

		if (res == 0) {
			System.out.println("equal");
			return -1;
		}
		if (res == 1) {

			System.out.println("neighbours");
			return 1;
		}
		else {
			return -1;

		}

		//return res;
	}
	public static void insertBitSeq(int i1,int i2 , int pos1, int pos2){
		int mask1 = ~(((1<< (pos1)))-1);
		int mask2 = ((1<< pos2)-1);
		int finalMask = mask1|mask2;
		i2 = i2<<pos2;
		System.out.println(Integer.toBinaryString(mask2));
		
	}
	public static byte convertToGreyCode(byte b1){
		byte result = (byte) (b1^(b1>>>1));
		System.out.println(Integer.toBinaryString((byte)result));
		return result;
	}
	 
	public static void printNextLargestAndSmallest(int num)
	{
		int maskForSetBits = 1;
		int c = num; 
		int noOfSetbits = 0;
		int noOfZerobits =0;
		while(((c&1)==0)&&(c!=0))
		{
			noOfZerobits++;
			c>>=1;
		}
		while((c&1)==1){
			noOfSetbits++;
			c =c>>1;
		}
		
	
		 //System.out.println(noOfSetbits);
		//System.out.println("Smallest" + Integer.toBinaryString(((1<<(noOfSetbits))-1))+"decimal");	
		//System.out.println("Largest" + Integer.toBinaryString((~((1<<((30-noOfSetbits)+1))-1))&~(1<<31))+"decimal"+((~((1<<((30-noOfSetbits)+1))-1))&~(1<<31)));	

	}
	public static int ReverseEvenAndOdd(int num)
	{
		return ((num&0xaaaaaaaa)>>1 | (num&0x55555555)<<1);	
	}
	public static void main(String[] args) {
		int a = -1000000;
		int b = 2;
		int c = 4;
		int e = 0b10011;
		System.out.println("xor" + (b ^ c));
		int d = 1;
		System.out.println(~d);
		d = (d & 0xffff);
		System.out.println(d);
		int i = 144;
		long bs = (long) i;
		System.out.println((b & 0xFFFFF));
		System.out.println(Integer.toHexString(b & 0xFF));
		System.out.println((long) (~bs & 0xfffff));

		System.out.println((~a));
		System.out.println((a << 1)); // shifting byte one place left and each
										// place we shift its multiplied by 2
		System.out.println((a << 2));
		System.out.println((b >>> 2));
		System.out.println((a >> 2));// preserves the sign , pads with the
										// most// significant Bit.

		System.out.println(new BitShift().ChkGrayCode((byte) -128, (byte) -128));
		System.out.println(new BitShift().ChkGrayCode((byte) -1, (byte) 127));
		System.out.println(new BitShift().ChkGrayCode((byte) -128, (byte) -100));
		System.out.println(new BitShift().ChkGrayCode((byte) 2, (byte) -2));
		System.out.println(new BitShift().ChkGrayCode((byte) 2, (byte) -126));
		System.out.println(new BitShift().ChkGrayCode((byte) 7, (byte) 15));
		convertToGreyCode((byte)(0b01010));
		insertBitSeq(0b10011100000,0b10011,7,3);
		printNextLargestAndSmallest(0b00001000);
		System.out.println("sas");
		System.out.println("1 2 3".split(" ")[0]);
		//System.out.print(Integer.toBinaryString(0xaaaaaaaa));
		System.out.print(Integer.toBinaryString(ReverseEvenAndOdd(9)));
	
	}

}

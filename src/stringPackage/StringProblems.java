package stringPackage;

public class StringProblems {

	public void replaceInCharArray(char[] str){
		
		int len = str.length;
		int ExtraLength =0;
		int newLength = 0;
		char[] newStr = null; 
		for (int i =0; i < len ;i++){
			if(str[i] == ' ')
				{
					ExtraLength++; //getting the length of spaces
					
				}
			}
		newLength = len + ExtraLength*2;
		newStr = new char[newLength];
		System.out.println("***"+newLength);//new length of the String-Character Array
		
		for(int i=len-1 ; i>-1; i-- ){
			if(str[i]==' '){
				newStr[newLength-1]='0' ;
				newStr[newLength-2]='2' ;
				newStr[newLength-3]='%' ;
				newLength = newLength-3;
				
			}
			else{
				newStr[newLength-1]=str[i];
				newLength = newLength-1;
			}
		}
		System.out.println(newStr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new StringProblems().replaceInCharArray("Hello String Replace".toCharArray());
	}

}

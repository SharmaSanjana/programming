package strings;

public class ReverseString {

	public static void main(String[] args) {
		
		String str  ="abcde"; //anajnas
		System.out.println("String before reverse " + str);
		
		/*String revString = reverseUsing2ptrsCharArray(str);
		System.out.println("String after reverse " + revString);*/
		
		String revString2 = reverseUsing2ptrsCharArray2(str);
		System.out.println("String after reverse " + revString2);
		
	}

	private static String reverseUsing2ptrsCharArray(String str) {
		char[] charArray = str.toCharArray();
		int i=0,j=charArray.length-1;
		for(int k =0;k<charArray.length;k++) {
			System.out.print(charArray[k]);
		}
		System.out.println("\ni="+i+" j="+j);
		while(i<j) {
			char temp;
			temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j]=temp;
			i++;j--;
		}
		System.out.println("i="+i+" j="+j);
		for(int k =0;k<charArray.length;k++) {
			System.out.print(charArray[k]);
		}
		String s = new String(charArray);
	return s;	
	}
	
	private static String reverseUsing2ptrsCharArray2(String s1) {
		
		int i=0, j=s1.length()-1;
		
		char str[] = s1.toCharArray(); char temp;
		
		while(i<j) {
			temp = str[j];
			str[j] = str[i];
			str[i] = temp;
			i++;j--;
		}
		String s = new String(str);
		return s;
		
		
	}

}

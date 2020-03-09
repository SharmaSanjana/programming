package strings;

public class IfStringHasAllUniqueChar {

	public static void main(String[] args) {
		String str = "sanjana";
		/*boolean flag = logic(str);
		if(flag)
			System.out.println("yes, all chars are unique");
		else 
			System.out.println("no, all chars are not unique");
		boolean flag1 = logic2(str);
		if(flag1)
			System.out.println("yes, all chars are unique");
		else 
			System.out.println("no, all chars are not unique");
		boolean flag3 = logic2(str);
		if(flag3)
			System.out.println("yes, all chars are unique");
		else 
			System.out.println("no, all chars are not unique");*/
		
		boolean flag4 = isUniqueCharsWOExtraSpace(str);
		if(flag4)
			System.out.println("yes, all chars are unique");
		else 
			System.out.println("no, all chars are not unique");
	}

	private static boolean logic(String str) {
		boolean flag = true;
		boolean[] temp = new boolean[256];
		
		for(int i=0; i<str.length(); i++) {
			if(temp[str.charAt(i)]==true)
				flag = false;
			temp[str.charAt(i)] = true;
		}
		
		return flag;
	}
	private static boolean logic2(String str) {
		boolean flag = true;
		int[] count = new int[256];
		char[] s1 = str.toCharArray();
		for(char c : s1) {
			count[c]++;
		}
		for(int i=0;i<count.length;i++) {
			if(count[i]>1)
				flag=false;
		}
		return flag;
	}
	
	private static boolean logic3(String str) {
		boolean flag = true;		
		boolean[] arr = new boolean[256];
		for(int i=0;i<str.length();i++) {
			if(arr[str.charAt(i)]) 
				flag = false;
			arr[str.charAt(i)] = true;
		}		
		return flag;
	}
	public static boolean isUniqueCharsWOExtraSpace(String str) {
		 int checker = 0;
		 for (int i = 0; i < str.length(); ++i) {
			 int a1 = str.charAt(i);
			 int val = a1 - 'a';
			 int leftShift = 1 << val;  // 2^18
			 int b = checker & leftShift;
			 if ((b) > 0) return false;
			 checker |= leftShift;
		 }
		 return true;
		 }

}

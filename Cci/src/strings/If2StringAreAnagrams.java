package strings;

import java.util.Arrays;

public class If2StringAreAnagrams {

	public static void main(String[] args) {
		String str1 = "hello"; String str2="lloeh";
//		if(logic(str1,str2))
//			System.out.println("yes");
//			else
//				System.out.println("no");
//		if(logic2WithCounting(str1,str2))
//			System.out.println("yes");
//			else
//				System.out.println("no");
		
		
		if(logic2WithCounting3(str1,str2))
			System.out.println("yes");
		else
				System.out.println("no");
		
	}

	private static boolean logic2WithCounting(String str1, String str2) {
		char[] caStr1 = str1.toCharArray();char[] caStr2 = str2.toCharArray();
		int[] count1 = new int[256];
		int[] count2 = new int[256];
		Arrays.fill(count1, 0);Arrays.fill(count2, 0);
		for(int i=0;i<caStr1.length&& i<caStr2.length;i++) {
			count1[caStr1[i]]++;
			count2[caStr2[i]]++;
		}
		for(int i=0;i<count1.length;i++) {
			if(count1[i] != count2[i]) {
				return false;
			}
		}
		return true;
	}
	private static boolean logic2WithCounting2(String s1, String s2) {
		int a1[]= new int[256]; int a2[] = new int[256];
		Arrays.fill(a1,0);Arrays.fill(a2, 0);
		char[] str1 = s1.toCharArray(); char[] str2 = s2.toCharArray();
		if(str1.length!=str2.length) return false;
		
		for(int i=0;i<str1.length&&i<str2.length;i++) {
			a1[str1[i]]++;
			a2[str2[i]]++;
		}
		
		for(int i=0; i<a1.length;i++)
			if(a1[i]!=a2[i]) return false;		
		
		return true;
	}
	
	private static boolean logic2WithCounting3(String str1, String str2) {
		int[] countArr = new int[256];
		char[] s1 = str1.toCharArray(); char[] s2 = str2.toCharArray();
		
		if(str1.length()!=str2.length()) return false;
		
		for(char c : s1)
			countArr[c]++;			
		for(char c : s2) {
			countArr[c]--;
		}
		for(int i=0;i<countArr.length;i++) {
			if(countArr[i]!=0) return false;
		}
		return true;
	}

	private static boolean logic(String str1, String str2) {
		if(str1.length()!=str2.length()) return false;
		char[] caStr1 = str1.toCharArray();
		StringBuilder sbStr2 = new StringBuilder(str2);
		for(char c : caStr1) {
			int index = sbStr2.indexOf(""+c);
			if(index!=-1)
				sbStr2.deleteCharAt(index);
			else
				return false;
		}
		return sbStr2.length()==0?true:false;
	}

}

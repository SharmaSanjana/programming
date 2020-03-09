package strings;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class RemoveDuplicatesFrmSring {

	public static void main(String[] args) {
		String s = "sanjana";
		/*String s1 = logic(s);
		System.out.println("after removing duplicates "+s1);
		String s2 = logic2(s);
		System.out.println("after removing duplicates "+s2);
		String s3 = logicConstantArray(s);
		System.out.println("after removing duplicates "+s3);
		String s4 = logic3_p(s);
		System.out.println("after removing duplicates "+s4);
		
		String s5 = logic4_p(s);
		System.out.println("after removing duplicates "+s5); //w/o constant array, and w/o string builder
		
		String s6 = logic2_p(s);
		System.out.println("after removing duplicates logic2_p = "+s6);*/
		
		String s7 = logic_dec(s);
		System.out.println("my logic december "+ s7);
		
		String s8 = logicLinkedHashMap(s);
		System.out.println("using linked hash map "+s8);
		
		String s9 = logicHashMap(s);
		System.out.println("using hash map "+s9);
	}

	private static String logicHashMap(String s) {
		String s1 = "";

		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			if(!countMap.containsKey(s.charAt(i))) {
				countMap.put(s.charAt(i), 1);
				s1 =s1 + s.charAt(i);
			}
			else {
				continue;
			}
		}		
		return s1;
	}

	private static String logicLinkedHashMap(String s) {
		String s1 = "";
		
		LinkedHashSet<Character> lhm = new LinkedHashSet<>();
		for(int i=0; i<s.length(); i++) {
			lhm.add(s.charAt(i));
			
		}
		//char[] ca = new char[lhm.size()];
		for(Character c: lhm) {
			s1 = s1+ c;
		}
		
		
		return s1;
	}

	private static String logic_dec(String s) {
		char[] charArr = s.toCharArray();
		
		Map<Character,Integer> map = new HashMap<>();
		for(int i =0; i<charArr.length; i++) {
			if(!map.containsKey(charArr[i])) {
				map.put(charArr[i], 1);
			}
			else {
				Integer j = map.get(charArr[i]);
				map.put(charArr[i], j+1);
			}
		}
		char[] newCharArr = new char[s.length()];
		int k=0;
		for(int i=0; i<charArr.length; i++) {
			if(map.get(charArr[i])==1) {
				newCharArr[k++] = charArr[i];
			}
		}
		String res = new String(newCharArr);
		return res;
	}

	private static String logic2_p(String s) {
		char[] ca = s.toCharArray();
		int tail=1,j;
		for(int i=1;i<ca.length;i++) {
			for(j=0;j<tail;j++) {
				if(ca[i]==ca[j]) break;
			}
			if(j==tail)
				ca[tail++] = ca[j];
			else
				ca[tail++] = 0;
		}
		StringBuilder res = new StringBuilder();
		for(int i=0;i<ca.length;i++) {
			if(ca[i]!=0)
				res.append(ca[i]);
		}
		return res.toString();
	}

	private static String logic4_p(String s) {
		char[] ca = s.toCharArray();
		boolean[] temp = new boolean[256];
		
		for(int i=0;i<ca.length;i++) {
			if(temp[ca[i]]) {
				ca[i]=0;
			}				
			temp[ca[i]]=true;				
		}
		StringBuilder res = new StringBuilder(ca.length);
		for(char c : ca) {
			if(c!=0)
				res.append(c);
		}
		return res.toString();
	}

	private static String logic3_p(String s) {
		char[] ca = s.toCharArray();
		boolean[] temp = new boolean[256];		
		for(int i=0; i< ca.length;i++) {
			if(temp[ca[i]]) {
				ca[i] = 0;
			}
			temp[ca[i]] = true;
		}
		StringBuilder sb = new StringBuilder(ca.length);
		for(int i=0;i<ca.length;i++) {
			if(ca[i]!=0)
				sb.append(ca[i]);
		}
		String s2 = sb.toString();
		return s2;
	}

	private static String logicConstantArray(String s) {
		char[] str = s.toCharArray();
		boolean[] arr =new boolean[256];

		arr[str[0]]= true;
		int tail=1;
		for(int i=1;i<str.length;i++) {
			if(!arr[str[i]]) {
				str[tail++] = str[i];
				arr[str[i]] = true;
			}else {
				str[tail++] = 0;				
			}
		}
		return toUniqueString(str);
	}

	private static String logic2(String s) {
		char[] str = s.toCharArray();
		int tail = 1;
		for(int i=1;i<str.length;i++) {
			int j;
			for(j=0;j<tail;j++) {
				if(str[i]==str[j]) break;
			}
			if(j==tail) {
				str[tail++] = str[j];
			}else {
				str[tail++] = 0;
			}
		}
		
		return toUniqueString(str);
	}

	private static String logic(String s) {
		char[] ca = s.toCharArray();
		int tail = 1;
		for(int i=1;i<ca.length;++i) {
			int j;
			for(j=0;j<tail;++j)
				if(ca[i]==ca[j]) break;				
			if(j == tail) {
				ca[tail] = ca[i];	
				++tail;
			}
			else {
				ca[tail] = 0;
				++tail;
			}
		}
		
		/*for(int k=0;k<ca.length;k++)
			System.out.print(ca[k]);*/
		
		return toUniqueString(ca);
	}

	private static String toUniqueString(char[] ca) {
		StringBuilder str =new StringBuilder(ca.length);
		for(int i=0;i<ca.length;i++) {
			if(ca[i]!=0) {
				str.append(ca[i]);
			}
		}
		return str.toString();
	}

}

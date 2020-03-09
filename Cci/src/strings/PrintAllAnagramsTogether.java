package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrintAllAnagramsTogether {
	
	public static void main(String args[]) {
		String arr[] = {"cat","dog","tac","god","act"};
		printAnagrams(arr);
		
	}

	private static void printAnagrams(String[] arr) {
		HashMap<String, List<String>> hm = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			String word = arr[i];
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String newWord = new String(letters);
			
			if(hm.containsKey(newWord)) {
				hm.get(newWord).add(word);
			}
			else {
				List<String> list = new ArrayList<>();
				list.add(word);
				hm.put(newWord, list);
			}
		}
		
		for(String s:hm.keySet()) {
			List<String> value = hm.get(s);
			System.out.println(value);
		}
		
	}
}

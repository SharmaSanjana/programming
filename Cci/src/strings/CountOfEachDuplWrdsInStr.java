package strings;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CountOfEachDuplWrdsInStr {

	public static void main(String[] args) {
		String str = "nam myoho renge kyo nam myoho renge kyo";
		String[] sa = str.split(" ");
		
		
		String[] s1 = str.split(" ");
		
		Map<String, Integer> map = new HashMap<>();
		
		for(String word : s1) {
			if(!map.containsKey(word)) 
				map.put(word, 1);
			else {
				int val = map.get(word);
				map.put(word, val+1);
			}		
		}
		
		System.out.println("before remove "+map);
		
		Iterator<Entry<String,Integer>> itr = map.entrySet().iterator();
		
		while(itr.hasNext()) {
			
			Entry<String,Integer> entry = itr.next();
			if((Integer)entry.getValue()>1)
				itr.remove();
		}
		
		PrintWriter wr = new PrintWriter(System.out);
		wr.write(str);
		wr.flush();
		wr.close();
		
		System.out.println("after remove "+map);
		
		
	}

}

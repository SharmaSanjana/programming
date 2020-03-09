package strings;

import java.util.Arrays;

public class IfStringHasAllUniqueChars {

	public static void main(String[] args) {
		String s = "Sanj";
		Boolean b = logicWithAddiDs(s);
		System.out.println("logicWithAddiDs "+b);

	}

	private static Boolean logicWithAddiDs(String s) {
		Boolean b = false;
		Boolean[] addDs = new Boolean[256];
		char j, k;
		Arrays.fill(addDs, false);
		for(int i=0; i<s.length(); i++) {
			if(addDs[s.charAt(i)]) {
				b = true;
				break;	
			}			
			else if(!addDs[s.charAt(i)])
				addDs[s.charAt(i)] =  true;
		}
		
		return b;
	}

}

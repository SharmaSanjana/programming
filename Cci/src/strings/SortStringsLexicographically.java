package strings;

public class SortStringsLexicographically {

	public static void main(String[] args) {
		String[] words = {"abc", "aac", "bcd"};
		logic(words);

	}

	private static void logic(String[] words) {
		int n = words.length;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(words[i].compareTo(words[j]) > 0) {
					String temp = words[i];
					words[i]  = words[j];
					words[j] = words[i];
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println("res is "+ words[i]); 
		}
		
	}

}

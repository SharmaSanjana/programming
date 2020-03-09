package strings;

public class ReplaceSpaces {

	public static void main(String[] args) {
		String s = "sanjana sharma biswas";
		char[] ca = s.toCharArray();
		String s1 = replaceSpacesLogic(ca, ca.length);
		System.out.println("result is " +s1);

	}

	private static String replaceSpacesLogic(char[] ca, int length) {
		
		int spaceCount = 0;
		for(int i=0;i<ca.length;i++) {
			if(ca[i]==' ')
				spaceCount++;
		}
		
		int newLength = length + spaceCount *2;
		char[] newCharArr = new char[newLength];
		
		for(int i = length-1;i>=0;i--) {
			if(ca[i]==' ') {
				newCharArr[newLength-1] = '0';
				newCharArr[newLength-2] = '2';
				newCharArr[newLength-3] = '%';
				newLength-=3;
			}
			else {
				newCharArr[newLength-1] = ca[i];
				newLength--;
			}
		}
		String s = new String(newCharArr);
		return s;
		
	}

}

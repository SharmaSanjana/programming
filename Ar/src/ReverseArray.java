
public class ReverseArray {

	public static void main(String[] args) {
		int a[] = {1,2,3,4};
		logicReveArray(a);
for(int i = 0;i<a.length;i++) {
	System.out.print(a[i]);
}
	}

	private static void logicReveArray(int[] a) {
		int i=0,j=a.length-1,temp;
		while(i<=j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;j--;
		}
		
	}

}

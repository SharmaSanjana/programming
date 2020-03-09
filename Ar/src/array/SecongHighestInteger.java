package array;

public class SecongHighestInteger {

	public static void main(String[] args) {
		int arr[] = {3,5,24,6,2,1,23};
		int result = logic(arr);
		System.out.println(result);

	}

	private static int logic(int[] arr) {
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
		
		if(arr.length<2) return -1;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>first) {
				second = first;
				first = arr[i];				
			}
			else if(arr[i]>second && arr[i]!=first) {
				second = arr[i];
			}				
		}		
		return second;
	}

}

package array;

public class Find2RepeatingElemPrac {

	public static void main(String[] args) {
		Find2RepeatingElemPrac repeat = new Find2RepeatingElemPrac(); 
		int arr[] = {4, 2, 4, 5, 2, 3, 1}; 
		int arr_size = arr.length; 
		repeat.printRepeating(arr, arr_size); 

	}

	/**
	 * @param arr
	 * @param arr_size
	 */
	
	private void printRepeating(int[] arr, int arr_size) {
		int[] count = new int[arr_size];
		for(int i=0;i<arr_size;i++) {
			if(count[arr[i]]==0) {
				count[arr[i]]++;
			}
			else
				System.out.println("repeating element is "+ arr[i]);
		}
		
	}

}

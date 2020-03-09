class Find2RepeatingElem 
{ 
	void printRepeatingWithCountArray(int arr[], int size) 
	{ 
		int count[] = new int[size]; 
		int i; 

		System.out.println("Repeated elements are : "); 
		for (i = 0; i < size; i++) 
		{ 
			if (count[arr[i]] == 1) 
				System.out.print(arr[i] + " "); 
			else
				count[arr[i]]++; 
		} 
	} 

	private void printRepeatingWOAuxSpace(int[] arr, int arr_size1) {
		//go to index arr[i]%n
		//increase its value with n
		//search again in array for each value, if its value/n >1, then its a repeated number
		for(int i=0;i<arr_size1;i++) {
			int index = arr[i]%arr_size1;
			arr[index] = arr[index] + arr_size1;
		}
		for(int i=0;i<arr_size1;i++) {
			if((arr[i]/arr_size1)>1)
				System.out.println(i);
				
		}		
	} 
	public static void main(String[] args) 
	{ 
		Find2RepeatingElem repeat = new Find2RepeatingElem(); 
		int arr[] = {4, 2, 4, 5, 2, 3, 1}; 
		int arr_size = arr.length; 
		repeat.printRepeatingWithCountArray(arr, arr_size); 
		
		/*Duplicates in an array in O(n) and by using O(1) extra space | Set-2
		Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.

		For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.*/
		
		System.out.println();
		int arr1[] = {1, 2, 3, 1, 3, 6, 6}; 
		int arr_size1 = arr1.length; 
		repeat.printRepeatingWOAuxSpace(arr1, arr_size1); 
	}

	
} 

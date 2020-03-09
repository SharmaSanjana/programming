package array;

//Java program to find maximum product subarray 

class MaxProdSubarray { 

	 
	public static void main(String[] args) 
	{ 

		int arr[] = { 1, -2, -3, 0, 7, -8, -2 }; 
		System.out.println("Maximum Sub array product is "
						+ maxSubarrayProduct(arr)); 
	}

	private static int maxSubarrayProduct(int[] A) {
		int max_ending_here = 1, min_ending_here = 1, max_so_far = 1, flag = 0;
	     
	     for(int i=0; i<A.length; i++){
	         if(A[i]>0){
	             max_ending_here = max_ending_here * A[i];
	             min_ending_here = Math.min(1,min_ending_here* A[i]);
	             flag = 1;
	         }
	         else if(A[i]==0){
	             max_ending_here = 1;
	             min_ending_here = 1;
	         }
	         else{
	             int temp = max_ending_here;
	             max_ending_here = Math.max(min_ending_here * A[i],1);
	             min_ending_here = temp * A[i];
	         }
	         
	         if(max_so_far < max_ending_here){
	             max_so_far = max_ending_here;
	         }
	     }
	     if(flag==0 && max_so_far == 1) return 0;
	     
	     return max_so_far;
	} 
}


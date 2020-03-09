package array;

import java.io.IOException;

public class MaxSumInArray {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
       long maxSum = 0; long sum = 0; 
       for(int i=0; i<a.length; i++) {
    	  sum = sum + a[i];
    	  if(sum < 0) sum = 0;
    	  if(sum>maxSum) maxSum = sum;
       }       
       return maxSum;
    }
    
    static long maximumSumPr(long[] a, long m) {
        long maxSum=0,sum=0;
        for(int i=0; i<a.length; i++) {
        	sum = sum+a[i];
        	if(sum<0) sum = 0;
        	if(sum>maxSum) maxSum = sum;
        }
        return maxSum;
     }

   

    public static void main(String[] args) throws IOException {
        
            long[] a = {-2, -3, 4, -1, -2, 1, 5, -3};

            long result = maximumSum(a, 5);
            
            System.out.println("result is "+result);
            
    
    }
}

package array;

public class Maxsprod {

	    public static int maxSpecialProduct(int[] A) {
	        int n = A.length;
	        int[] left = new int[n];
	        int[] right = new int[n];
	        
	        if (n == 0) return 0;
	        left[0] = 0;
	        for (int i = 1; i < n; i++) {
	            int j = i - 1;
	            while (j > 0) {
	                if (A[j] > A[i]) {
	                    left[i] = j;
	                    break;
	                } else {
	                    j = left[j];
	                }
	            }
	        }
	        
	        right[n - 1] = 0;
	        for (int i = n - 2; i >= 0; i--) {
	            int j = i + 1;
	            while (j > 0) {
	                if (A[j] > A[i]) {
	                    right[i] = j;
	                    break;
	                } else {
	                    j = right[j];
	                }
	            }
	        }
	        long max = -1;
	        for (int i = 0; i < n; i++) {
	            max = Math.max(max, (long) left[i] * right[i]);
	        }
	        return (int) (max % 1000000007);
	    }
	    
	    public static void main(String args[]) {
	    	
	    	int[] A = {6, 7, 9, 5, 5, 8};
	    	int a = maxSpecialProduct(A);
	    	System.out.println(a);
	    }
	    
	}




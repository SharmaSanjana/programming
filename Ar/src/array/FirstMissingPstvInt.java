package array;

public class FirstMissingPstvInt {

	    public static int firstMissingPositive(int[] A) {
	        int n = A.length;
	        int[] d = new int[n+1];
	        
	        
	        for(int i=0;i<n;i++){
	            if(A[i]>0 && A[i]<n) d[A[i]]++;
	            
	        }
	        if(n==1 && A[0]!=1) return 1;
	        else if(n==1 && A[0]==1) return 2;    
	        int i=0;
	         for(i=1;i<n;i++){
	           if(d[i]==0) return i;
	        }
	        
	    return i+1;
	    }
	    public static void main(String args[]) {
	    	
	    	int[] A = { 1, 2, 3, 4, 5, 6};
	    	int a = firstMissingPositive(A);
	    	System.out.println(a);
	    }
	    
}

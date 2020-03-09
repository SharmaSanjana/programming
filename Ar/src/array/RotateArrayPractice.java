package array;

public class RotateArrayPractice {

	public static void main(String[] args) {
		RotateArrayPractice rap = new RotateArrayPractice();
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		
		//Juggling Algorithm O(n), aux space O(1)
		rap.logicRotateArray(a,2,12);
		rap.printArray(a,12);
		
		System.out.println();
		//rotate one by one O(n*d) ---- aux space O(1)
		int b[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		rap.logic2RotateArray(b,2,12);
		rap.printArray(b, 12);
	}

	private void logic2RotateArray(int[] a, int d, int n) {
		int temp;
		for(int i=0;i<d;i++) {
			temp = a[0];
			for(int j=1;j<n;j++) {				
				a[j-1] = a[j];
			}
			a[n-1] = temp;			
		}		
	}

	private void printArray(int[] a, int size) {
		for(int i =0;i<size;i++) {
			System.out.print(a[i] +" ");
		}
		
	}

	private void logicRotateArray(int[] arr, int d, int n) {
		
		int i,j,k,temp;
		int gcdRes = gcd(d,n);
		for(i=0; i<gcdRes; i++) {
			temp = arr[i];
			j=i;
			while(true) {
				k = j + d;
				if(k>=n)
					k = k - n;
				if(k==i)
					break;
				arr[j] = arr[k];
				j = k;
				
			}
			arr[j] = temp;
		}		
	}

	private int gcd(int d, int n) {
		if(n==0)
			return d;
		else
		return gcd(n,d%n);
	}

}

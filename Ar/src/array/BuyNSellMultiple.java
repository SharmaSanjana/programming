package array;

public class BuyNSellMultiple {

	public static void main(String[] args) {
		Integer arr[] = { 100, 180, 260, 310, 40, 535, 695};
		
		int res = logicOrderNsquare(arr,0,arr.length);
		System.out.println("n square "+ res);

	}

	private static int logicOrderNsquare(Integer[] arr, int start, int n) {
		int maxProfit = 0;
		
		int i = 0; 
	    while (i < n - 1) { 
			
			while((i<n-1)&& arr[i+1]<=arr[i])
				i++;
			
			if(i==n-1) break;
			
			int a = i++;
			
			while((i<n)&& arr[i-1]<=arr[i])
				i++;
			
			int b = i-1;
			
			maxProfit+=(arr[b]-arr[a]);
			System.out.println("a="+a+" b="+b+" profit is "+(arr[b]-arr[a]));
		}
		
		return maxProfit;
	}

}

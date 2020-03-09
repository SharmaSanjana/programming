package array;

public class BuyNSell {

	public static void main(String[] args) {
		Integer arr[] = { 100, 180, 260,800, 310, 40, 535, 695, 700 };
		//int max = logic(arr);
		int max = logic2(arr);
		System.out.println(max);
	}

	private static int logic2(Integer[] arr) {
		int n = arr.length, max_value = arr[n-1], max_profit = Integer.MIN_VALUE, max_value_index = n-1, second=0;
		
		for(int i=n-1;i>=0;i--) {
			if(arr[i]>max_value) {
				max_value = arr[i];
				max_value_index = i;
			}
			max_profit = max_logic(max_value - arr[i],max_profit); 
			second = i;
		}
		System.out.println(max_value_index+ " "+ second);
		return max_profit;
	}

	private static int logic(Integer[] arr) {
		int n = arr.length, max = Integer.MIN_VALUE;
		/*for(int i=n-2;i>=0;i++) {
			
		}*/
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[j]>arr[i]) {
					//max = max_logic(arr[j]-arr[i],max);
					max = (arr[j]-arr[i])>max?arr[j]-arr[i]:max;
				}
			}
		}
		return max;
		
	}

	private static int max_logic(int i, int j) {
		
		return i>j?i:j;
	}
}

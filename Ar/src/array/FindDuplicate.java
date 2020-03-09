package array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {

public static int repeatedNumber(final List<Integer> A) {
        
        if(A.size()<=1) return -1;
        
        int slow = A.get(0);
        int fast = A.get(A.get(0));
        
        while(fast!=slow){
            slow = A.get(slow); 
            fast = A.get(A.get(fast));
        }
        fast = 0;
        while(fast!=slow){
            slow = A.get(slow); 
            fast = A.get(fast);
        }
        return slow;
    }
public static void main(String args[]) {
	
	List<Integer> A = new ArrayList<>();
	A.add(3);A.add(4);A.add(1);A.add(4);A.add(1);
	int a = repeatedNumber(A);
	System.out.println(a);
}
}

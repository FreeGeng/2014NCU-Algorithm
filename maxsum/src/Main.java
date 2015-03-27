import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int solution[];
	static int a[];
	static int N;
	

	public static void main(String args[]) {
		while (scanner.hasNext()) {
			String temp[] = scanner.nextLine().split(" ");
			N = Integer.parseInt(temp[0]);
			a = new int[N];
			

			if (N != 0) {
				for (int i = 0; i < N; i++) {
					a[i] = Integer.parseInt(temp[i + 1]);
				}
				findMaxSubArray(a);
			
			}
			else{
				System.exit(0);
			}
		}
	}
	 public static void findMaxSubArray(int[] inputArray){
		 
	        int maxStartIndex=0;
	        int maxEndIndex=0;
	        int maxSum = 0; 
	 
	        int cumulativeSum= 0;
	        int maxStartIndexUntilNow=0;
	        		
	        for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {
	        	
	            int eachArrayItem = inputArray[currentIndex];
	            
	            cumulativeSum+=eachArrayItem;
	 
	            if(cumulativeSum>maxSum){
	                maxSum = cumulativeSum;
	                maxStartIndex=maxStartIndexUntilNow;
	                maxEndIndex = currentIndex;
	            }
	            if (cumulativeSum<0){
	            	maxStartIndexUntilNow=currentIndex+1;
	            	cumulativeSum=0;
	            	}
	        }
	 
	        System.out.println(maxSum+" "+maxStartIndex+" "+maxEndIndex);
	       
	    }
	
}

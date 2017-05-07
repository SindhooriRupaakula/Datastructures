import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class MaxLengthSubArr {
	
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
//		int[] input = new int[20];
//		//Scanner sc = new Scanner(System.in).useDelimiter("[ ]") ;
//		for(int i=0;sc.hasNext() && (i<20);i++){
//			input[i] = sc.nextInt();
//		}
//		
//		System.out.println( findMaxLength(input));
		System.out.println( findMaxLength(new int[]{0,1,0,1,1,0,1,1}));
	}
	
	public static int findMaxLength(int[] a){
		//using HashMap find the max length of the sub array that has equal number of 1's and 0's
		//O(n) time complexity
		System.out.println("Here1");
		HashMap<Integer,Integer> h = new HashMap<Integer, Integer>();
		int count = 0;
		int maxlength = 0;
		h.put(0, -1);
		for(int i=0;i<a.length;i++){
			System.out.println("Here2===");
			if(a[i] == 1){ count += 1;}
			else count+=-1;
			
			if(h.containsKey(count)){
				maxlength = Math.max(maxlength, i-h.get(count));
			}
			else {h.put(count, i);}
		}
		return maxlength;
	}
}

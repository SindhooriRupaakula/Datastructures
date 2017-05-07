import java.util.*;
import java.lang.*;
import java.io.*;
	
public class SubarrayWithGivenSum {



	public static void main (String[] args) {
		//code
		int tests;
		Integer[] arr;
		Scanner sc = new Scanner(System.in);
		try{
		tests = sc.nextInt();
		for(int i=0; i<tests; i++){
		    int length = sc.nextInt();
		    int target = sc.nextInt();
		    arr = new Integer[length];
		    for(int j=0; j<length; j++){
		        arr[j] = sc.nextInt();
		    }
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
}
}

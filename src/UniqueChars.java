import java.util.HashSet;

public class UniqueChars {
	
	public static Boolean isUnique1(String s){
		// This method is to find if string is unique using hash set.
		HashSet<Character> checker = new HashSet<Character>();
		Boolean result = false;
		for(int i=0; i<s.length();i++){
			result = checker.add(s.charAt(i));
			if(result == false){
				return false;
			}
		}
		return true;	
	}
	
	public static Boolean isUnique2(String s){
		int checker =0;
		for(int i=0; i<s.length(); i++){
			int val = s.charAt(i)-'a';
			if((checker & (1 << val)) >0)
				{return false;}
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String args[]){
		//Here, Small and big letters are different.
		Boolean unique1 = isUnique1("My Name");
		System.out.println(unique1);
		
		Boolean unique2 = isUnique2("My Name is Maggi");
		System.out.println(unique2);
		
	}
}

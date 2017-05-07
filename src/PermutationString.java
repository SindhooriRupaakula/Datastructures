//Given 2 strings, check if one is permutation of other.
public class PermutationString {

	public static String sort(String s){
		char[] arr = s.toCharArray();
		java.util.Arrays.sort(arr);
		return new String(arr);
	}
	
	public static Boolean isPermutation1(String s1, String s2){
		//sort both Strings and check if same.
		if(s1.length() != s2.length())
			return false;
		return sort(s1).equals(sort(s2));
	}
	
	public static Boolean isPermutation2(String s1, String s2){
		//check character counts and see if same
		if(s1.length() != s2.length())
			return false;
		Integer[] letterCount= new Integer[128];
		for(int i = 0; i<s1.length(); i++){
			letterCount[(int)s1.charAt(i)]++;
		}
		
		for(int i = 0; i<s2.length(); i++){
			int c = (int)s1.charAt(i);
			letterCount[c]--;
			if(letterCount[c] < 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		System.out.println(isPermutation1("The quick brown fox jumps over the lazy dog.", "aooobc deeref ghij klmn hopq rsT uv utwx yz."));
		System.out.println(isPermutation1("god", "good"));
		System.out.println(isPermutation1("The kcuq i", "The quic k"));
		
		System.out.println(isPermutation2("The quick brown fox jumps over the lazy dog.", "abc def ghij klmn opq rsT uv wx yz."));
		System.out.println(isPermutation2("god", "good"));
	}
}

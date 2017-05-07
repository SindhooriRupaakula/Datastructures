
public class URLify {

	public static void replaceSpaces(String s1, int length){
		int spaces=0, i=0, index;
		char[] s = s1.toCharArray();
		for(i=0; i<length; i++){
			if(s[i] == ' ')
				spaces++;
		}
		System.out.println(spaces);
		index = length + spaces*2;
		System.out.println(index);
		if (length < s.length) s[length] = '\0'; // end of array
		for(i=length-1; i>0; i--){
			if(s[i] == ' '){
				s[index-1] = '0';
				s[index-2]= '2';
				s[index-3]= '%';
				index -=3;
			}
			else {
				s[index-1] = s[i];
				index--;
			}	
		}
		
		System.out.println(s);
		// Doesn't work ----> why?? ------> System.out.println(s.toString());
	}
	
	public static void main(String args[]){
		replaceSpaces("Mr John Smith    ", 13);
	}
}

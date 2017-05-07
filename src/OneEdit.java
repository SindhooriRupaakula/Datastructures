
public class OneEdit {

	String s1, s2;
	
	OneEdit(String s1, String s2){
		this.s1 = s1;
		this.s2 = s2;
	}
	
	Boolean isOneEdit(){
		if(s1.equals(s2))
			return true;
		else if(s1.length() == s2.length())
			return replace(s1, s2);
		else if(s1.length() < s2.length())
			return insert(s1, s2);
		else return insert(s2, s1);
	}
	
	Boolean replace(String s1, String s2){
		Boolean flag = false;
		for(int i=0; i<s1.length(); i++){
			if((s1.charAt(i)==s2.charAt(i)) && flag)
				return false;
			flag = true;
		}
		return true;
	}
	
	Boolean insert(String small, String big){
		if(Math.abs(small.length()- big.length()) > 1)
			return false;
		else {
			Boolean insert1 = false;
			for(int i=0, j=0; (i<s1.length()) && (j<s2.length()) ; i++, j++){
				if(small.charAt(i) != big.charAt(j)){
					if(insert1)
						return false;
					else if(big.charAt(j+1) == small.charAt(i)){
						j++;
						insert1 = true;
					}
					else return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		OneEdit e = new OneEdit("pale", "ple");
		System.out.println(e.isOneEdit()); 
		
		OneEdit e1 = new OneEdit("pale", "pla");
		System.out.println(e.isOneEdit()); 
		
		OneEdit e2 = new OneEdit("pale", "bae");
		System.out.println(e.isOneEdit()); 
	}
	
}

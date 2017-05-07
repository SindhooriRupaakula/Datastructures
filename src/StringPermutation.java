
public class StringPermutation {
	String s;
	int[] table;
	
	StringPermutation(String s1){
		this.s = s1;
		this.table = new int[Character.getNumericValue('z')- Character.getNumericValue('a')+1];
		for(char c: s.toCharArray()){
			int val = getCharValue(c);
			if(val > -1){
				table[val]++;
				
				System.out.println(val);
			}
		}
		System.out.println(table[0]);
	}
	
	int getCharValue(char c){
		int x= Character.getNumericValue(c);
		int a= Character.getNumericValue('a');
		int z= Character.getNumericValue('z');
		if((x>=a) && (x<=z)){
			return (Character.getNumericValue(c)-Character.getNumericValue('a'));
		}
		return -1;
		
	}
	
	public Boolean isPermutation(){
		Boolean oneOdd = false;
		for(int i=0; i<table.length; i++){
			if(table[i] % 2 != 0){
				if(oneOdd)
					return false;
				else oneOdd = true;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		StringPermutation p = new StringPermutation("tact coao");
		System.out.println( p.isPermutation());
		
		StringPermutation p1 = new StringPermutation("tackt coaom");
		System.out.println( p1.isPermutation());
	}
}

class Node2{
	Object key;
	Object val;
	Node2 next;
	public Node2(Integer key, String val){
		this.key = key;
		this.val = val;
		this.next = null;
	}
}
public class MyHashTable {
	static Node2[] buckets;
	static int size, length;
	
	MyHashTable(int length){
		MyHashTable.length= length;
		buckets = new Node2[length];
		size = 0;
	}
	
	//hash 
	public static int hash(Integer key){
		return (key % length);
	}
	
	//get
	public Integer get(Integer key){
		return 0;
	}
	
	//put
	public void put(Integer key, String val){
		int index = hash(key);
		if(buckets[index] == null){
			buckets[index] = new Node2(key, val);
			size++;
			return;
		}
			Node2 temp = buckets[index];
			
			if(temp.key == key)
			{
				temp.val = val;
				return;
			}
			while(temp.next != null) {
				if(temp.key == key)
					{
						temp.val = val;
						return;
					}
				temp = temp.next;
			} 
			temp.next = new Node2(key, val);
			size++;
			return;
	}
	
	public void getValue(Integer k){
		int index = hash(k);
		Node2 temp = buckets[index];
		while(temp != null){
			if(temp.key == k){
				System.out.println(temp.val); 
				return;
			}
		}
		
		System.out.println("NO VALUE"); 
		
	}
	
	//remove
	public Boolean remove(Integer k){
		int index = hash(k);
		Node2 temp = buckets[index];
		
		if(temp.key == k){
			buckets[index] = temp.next;
			size--;
			return true;
		}
		
		while(temp.next != null){
			if(temp.next.key == k){
				temp.next = temp.next.next;
				size--;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	//number of elements
	public void getSize(){
		System.out.println("Size- "+size);
	}
	
	//display
	public void display(){
		for(int i=0; i<length; i++){
			Node2 temp = buckets[i];
			while(temp != null){
				//System.out.println("Here");
				System.out.println(temp.key+" -> "+temp.val+'\n');
				temp = temp.next;
			}
		}
	}
	
	public static void main(String args[]){
		MyHashTable tab = new MyHashTable(10);
		tab.put(10, "a");
		tab.put(18, "b");
		tab.put(3, "c");
		tab.put(13, "f");
		tab.put(12, "d");
		tab.put(11, "e");
		tab.put(1, "g");
		tab.display();
		tab.getSize();
		System.out.println("======Removing 18=======");
		tab.remove(18);
		tab.display();
		tab.getSize();
		System.out.println("======Removing 13=======");
		tab.remove(13);
		tab.display();
		tab.getSize();
		System.out.println("======Removing 11=======");
		tab.remove(11);
		tab.display();
		tab.getSize();
		tab.put(11, "e");
		System.out.println("======Get Value=======");
		
	}
}

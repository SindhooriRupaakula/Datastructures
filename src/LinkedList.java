//use comparator to make any node data comparable like int.
public class LinkedList {
	public Link head;
	
	LinkedList(){
		head = null;
	}
	
	public void addAtBeginning(int data){
		Link link = new Link(data);
		link.next = head;
		head = link;
	}
	
	public void addAtEnd(int data){
		Link current = head;
		if(current == null){
			current = new Link(data);
			head = current;
			return;
		}
		while(current.next != null){
			current = current.next;
		}
		Link link = new Link(data);
		current.next = link;
	}
	
	public boolean addAfterEqual(int findData, int data){
		Link current = head;
		if(current == null){
			return false;
		}
		
//		if(current.data == findData){
//			Link link = new Link(data);
//			link.next = current.next;
//			current.next = link;
//			return true;
//		}
		
		while(current!=null){
			if(current.data == findData){
				Link link = new Link(data);
				link.next = current.next;
				current.next = link;
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public void deleteAtBegin(){
		head = head.next;
	}
	
	public void deleteAtEnd(){
		Link current = head;
		if(current.next == null || current == null){
			head = null;
			return;
		}
		while(current.next.next!=null){
			current = current.next;
		}
		current.next = null;
	}
	
	public boolean deleteAfterEqual(int findData){
		Link current = head;
		if(current == null){
			return false;
		}
		
		while(current.next!=null){
			if(current.data == findData){
				current.next = current.next.next;
				return true;
			}
			current = current.next;
		}
		if(current.data == findData){
			return true;
		}
		return false;
	}
	
	public void reverse(){
		Link current = head;
		Link previous = null;
		
		while(current != null){
			Link next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
	
	public void display(Link head){
		Link current = head;
		if(current == null){
			System.out.println("-------No data in Linked List-----");
			return;
		}
		System.out.println("\nLinked List data:   ");
		while(current != null){
			System.out.print(current.data + "  ");
			current = current.next;
		}
	}
	
	public static void main(String args[]){
		LinkedList list= new LinkedList();
		list.addAtBeginning(1);
		list.display(list.head);
		list.addAtBeginning(2);
		list.display(list.head);
		list.addAtEnd(3);
		list.display(list.head);
		list.addAtEnd(4);
		list.display(list.head);
		list.addAfterEqual(3, 8);
		list.display(list.head);
		list.addAfterEqual(2, 9);
		list.display(list.head);
		list.deleteAtBegin();
		list.display(list.head);
		list.deleteAtEnd();
		list.display(list.head);
		list.deleteAfterEqual(9);
		list.display(list.head);
		list.reverse();
		list.display(list.head);
	}
}

class Link {
	public int data;
	public Link next;
	
	Link (int data){
		this.data = data;
		next = null;
	}
}
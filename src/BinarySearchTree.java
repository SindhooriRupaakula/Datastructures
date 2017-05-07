
public class BinarySearchTree {
	public Node root;

	BinarySearchTree(){
		root = null;
	}

	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2); bst.insert(9); bst.insert(10); bst.insert(3); bst.insert(5); bst.insert(4);
		System.out.println("Display BST inorder: ");
		bst.display(bst.root);
		System.out.println("Display BST preorder: ");
		bst.display2(bst.root);
		System.out.println("Display BST postorder: ");
		bst.display3(bst.root);
		System.out.println("Find 10: " + bst.find(10));
		System.out.println("Find right: " + bst.root.Right.data);
		System.out.println("======================");
		System.out.println("Delete 3: " +bst.delete(3));
		bst.display(bst.root);

	}

	public Boolean find(int x){
		Node current = root;
		while(current != null){
			if(current.data == x){
				return true;
			}
			if(x < current.data){
				current = current.Left;
			}
			else if(x > current.data){
				current = current.Right;
			}
		}
		return false;
	}

	public void display(Node root){

		if (root != null){
			display(root.Left);
			System.out.println(" " + root.data);
			display(root.Right);
		}
	}

	public void display2(Node root){
		if(root!=null){
			System.out.println(" " + root.data);
			display2(root.Left);
			display2(root.Right);
		}
	}

	public void display3(Node root){
		if(root!=null){	
			display3(root.Left);
			display3(root.Right);
			System.out.println(" " + root.data);
		}
	}

	public void insert(int x){

		if(root == null){
			root = new Node(x);
			return;
		}

		Node current = root;
		while(true){
			if(x < current.data){
				if(current.Left==null){
					current.Left = new Node(x);
					return;
				}
				current = current.Left;				
			}
			else if(x > current.data){

				if(current.Right==null){
					current.Right = new Node(x);
					return;
				}
				current = current.Right;			
			}
		}
	}

	public boolean delete(int x){
		Node current = root;
		Node parent = current;
		boolean rightChild = false;
		while(current.data != x){
			if(x < current.data){
				parent = current;
				current = current.Left;	
				rightChild = false;
			}
			else if(x > current.data){
				parent = current;
				current = current.Right;	
				rightChild = true;
			}
			if(current == null) 
				return false;
		}


		//Leaf Node
		if(current.Right == null && current.Left == null){
			if(current == root){
				root = null;
			}
			else if(rightChild){
				parent.Right = null;
			}
			else {
				parent.Left = null;
			}
		}

		//Node with one child
		else if(current.Left == null){
			if(current == root){
				root = current.Right;
			}
			else if(rightChild){
				parent.Right = current.Right;
			}
			else parent.Left = current.Right;
			return true;
		}
		else if(current.Right == null){
			if(current == root){
				root = current.Right;
			}
			else if(rightChild){
				parent.Right = current.Left;
			}
			else parent.Left = current.Left;
			return true;
		}

		//Node with two child nodes- lowest of right subtree.
		System.out.println("===========here");
		Node successor = getSuccessor(current);
		if(current == root){
			root = successor;

		}
		else if(rightChild){
			parent.Right = successor;
		}
		else parent.Left = successor;

		successor.Left = current.Left;


		return true;

	}

	public Node getSuccessor(Node toDelete){
		Node successor = null;
		Node successorParent = null;
		Node current = toDelete.Right;

		while(current!=null){
			successorParent = successor;
			successor = current;
			current = current.Left;			
		}

		if(successor != toDelete.Right){
			successorParent.Left = successor.Right;
			successor.Right = toDelete.Right;
		}
		return successor;
	}


}


class Node {
	public int data;
	public Node Left;
	public Node Right;

	Node(int data){
		Left = null;
		Right = null;
		this.data = data;
	}
}
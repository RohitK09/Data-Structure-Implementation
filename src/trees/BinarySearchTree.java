package trees;

public class BinarySearchTree {
		
		Node root ; 
		
public void addNode(int key,String txt){
	
	Node newnode = new Node(key,txt);
	if (root == null)
	{
		root = newnode;
	}else
	{
		Node focusNode = root ; 
		Node parent ; 
		while (true)
		{
			parent = focusNode;
			if(key<focusNode.key){
			focusNode = focusNode.left;
				if (focusNode == null ){
					parent.left = newnode;
					return;
				}
			}
			else{
				focusNode = focusNode.right;
				if(focusNode == null){
					parent.right = newnode;
					return ;
				}
			}
		}
	}
	
} 
public Node findNode(int key){
	Node FocusNode ; 
	FocusNode = root ; 
	
	while(key != FocusNode.key){
		if (key>FocusNode.key){
			FocusNode = FocusNode.right;
		}
		else{
			FocusNode = FocusNode.left;
		}
		if (FocusNode== null){
			return null ;
		}
	}
	return FocusNode;
}
public void InTraversal(Node node){
		if (node!=null)
		{
			InTraversal(node.left);
			System.out.println(node);
			InTraversal(node.right);
		}
			
			
}
public void PreOrderTraversal(Node node){
	if (node!=null)
	{
		System.out.println(node);
		PreOrderTraversal(node.left);
		
		PreOrderTraversal(node.right);
	}
}
	public boolean removeNode(int key)
	{
		Node focusNode,parentNode; 
		focusNode = root ;
		parentNode = root;
		boolean isItAtLeft = true ;
		boolean isItAtRight = true ;
		
		 while (key != focusNode.key){
			 if (key>focusNode.key){
				 isItAtRight = true;
				 parentNode = focusNode;
				 focusNode = focusNode.right;
			 }
			 else{
				 isItAtLeft = true;
				 focusNode = focusNode.left;
			 }
			 if(focusNode == null )
			 {
				return false ;  
			 }
			 if(focusNode.left == null && focusNode.right== null ) //handling leaf nodes 
			 {
				 if (focusNode == root) {
					 root = null ; 
				 }
				 else if (isItAtLeft)
				 {
					 parentNode.left= null ;  
				 }
				 else{
					 parentNode.right = null ; 
				 }
			 }
			 else if ( focusNode.left == null){
				if ( focusNode == root){
					root = focusNode.right;
				}
				else if(isItAtLeft){
					parentNode.left = focusNode.right;
				}
				else if(isItAtRight){
					parentNode.right = focusNode.right;
				}
			}
			 else if (focusNode.right == null){
				 if(focusNode == root ){
					 root = focusNode.right;
				 }
				 else if(isItAtLeft){
					 parentNode.left = focusNode.left;
				 }
				 else if (isItAtRight){
					 parentNode.right = focusNode.left;
				 }
			 }
			 //handling when it has both the children 
			 else
			 {
				 
				 
				 
				 if(isItAtLeft)
				 {
					focusNode.right.left = focusNode.left; 
					parentNode.left = focusNode.right;
					
				 }
				 if(isItAtRight)
				 {
					 focusNode.right.left = focusNode.left; 
					 parentNode.right = focusNode.right;
				 }
			 }
		}
		return true ; 
		
	}	
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bt = new BinarySearchTree();
		bt.addNode(50, "A");
		bt.addNode(60, "B");
		bt.addNode(40, "c");
		bt.addNode(70, "d");
		bt.addNode(30, "B");
		bt.InTraversal(bt.root);
		//bt.PreOrderTraversal(bt.root);
		System.out.println(bt.removeNode(40));
		//System.out.println(bt.findNode(41));
		//System.out.println(bt.removeNode(30));
		bt.InTraversal(bt.root);
	}

}

class Node 
{
	public int key  ; 
	public String txt ;
	Node left;
	Node right;
	
 public Node(int id,String txt) {
	this.key = id;
	this.txt = txt;
}
 public String toString(){
	 StringBuffer buf = new StringBuffer();
	 return  buf.append(key).append(txt).toString();
 }
}

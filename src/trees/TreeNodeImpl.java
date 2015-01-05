package trees;

public class TreeNodeImpl {
	public TreeNodeImpl left;
	public TreeNodeImpl right;
	public int Value;
	public int height = 1;

	public TreeNodeImpl newTreeNode(int value) {
		TreeNodeImpl newNode = new TreeNodeImpl();
		newNode.Value = value;
		newNode.left = null;
		newNode.right = null;

		return newNode;
	}

	public int recSize(TreeNodeImpl node) {
		if (node == null) {
			return 0;
		} else {
			return (recSize(node.left) + 1 + recSize(node.right));
		}
	}

	public int recHeight(TreeNodeImpl node) {

		if (node == null) {
			return 0;
		} else {
			int leftHeight = recHeight(node.left);
			int rightHeight = recHeight(node.right);
			if (leftHeight > rightHeight) {
				return leftHeight + 1;
			} else {
				return rightHeight + 1;
			}
		}
	}

	// this method recursively checks for every node and its height o(n^2)
	public boolean balancedOrNot(TreeNodeImpl head) {
		TreeNodeImpl node = head;
		if (head == null) {
			return true;
		}
		int leftHeight = recHeight(node.left);
		int rightHeight = recHeight(node.right);
		if (leftHeight - rightHeight > 1) {
			return false;
		} else {
			// recursive call again
			return balancedOrNot(node.left) && balancedOrNot(node.right);
		}
	}

	/*
	 * @Author : Rohit Katyal O(n)
	 */
	private int checkHeight(TreeNodeImpl head) {
		TreeNodeImpl node = head;
		if (node == null) {
			return 0;
		}
		int rightHeight = node.checkHeight(node.right);
		if (rightHeight == -1) {
			return -1;
		}
		int leftHeight = node.checkHeight(node.left);
		if (leftHeight == -1) {
			return -1;
		}
		if(Math.abs(leftHeight-rightHeight)> 1){
			return  -1 ;
		}
		else {
			return Math.max(rightHeight, leftHeight)+1;
		}
	}
	public boolean balancedOrNot2(TreeNodeImpl head) {
		int check = checkHeight(head);
		if( check ==-1)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}

	public static void main(String[] args) {
		TreeNodeImpl node = new TreeNodeImpl();
		node.Value = 6;
		node.left = node.newTreeNode(20);
		node.left.left = node.newTreeNode(30);
		node.right = node.newTreeNode(30);
		node.right.right = node.newTreeNode(32);
		node.left.left.left = node.newTreeNode(56);
		/*
		 * node.right.left.left=node.newTreeNode(32);
		 * node.right.left.left.left=node.newTreeNode(32);
		 * node.right.left.left.left.left=node.newTreeNode(32);
		 * node.left.left.right = node.newTreeNode(34); node.left.left.left =
		 * node.newTreeNode(34); //int Size = node.recSize(node);
		 * //System.out.println(Size); //int height = node.recHeight(node);
		 * //System.out.println(height);
		 */
		System.out.println(node.balancedOrNot2(node));
	}

}
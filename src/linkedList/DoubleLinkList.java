package linkedList;

public class DoubleLinkList {
	public DoubleLinkList(int value, DoubleLinkList next, DoubleLinkList prev) {
		super();
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
	int value = 0;
	DoubleLinkList next;
	DoubleLinkList prev;
	public int findlengthNode() {
		int i = 0;
		DoubleLinkList tempNode = this;
		while (tempNode != null) {
			tempNode = tempNode.next;
			i++;
		}
		return i;
	}

}
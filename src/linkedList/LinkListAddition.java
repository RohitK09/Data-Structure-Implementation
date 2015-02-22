package linkedList;

public class LinkListAddition {

	public DoubleLinkList add(DoubleLinkList l1, DoubleLinkList l2, int carry) {

		
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		DoubleLinkList result = new DoubleLinkList(carry,null,null);
		int value = carry;
		if (l1 != null) {
			value = value + l1.value;
		}
		if (l2 != null) {

			value = value + l2.value;
		}
		result.value =  value % 10;
		if (l1 != null && l2 != null) {
			DoubleLinkList more = add(l1 == null ? null : l1.next,
					l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.next = more;

		}
		return result;

	}

	public DoubleLinkList addlist(DoubleLinkList L1, DoubleLinkList L2) {
		int length1 = L1.findlengthNode();
		int length2 = L2.findlengthNode();
		if (length1 - length2 > 0) {
			padwithZero(L2, length1 - length2);
		} else if (length1 - length2 < 0) {
			padwithZero(L1, length2 - length1);
		}
		PartialSum sum = addListsHelper(L1, L2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			return insertBefore(sum.sum, sum.carry);
		}
	}

	public PartialSum addListsHelper(DoubleLinkList l1, DoubleLinkList l2) {
		// handle edge case
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val = l1.value + l2.value + sum.carry;
		DoubleLinkList full_result = insertBefore(sum.sum, val % 10);
		/* Return sum so far, and the carry value */
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
		// return null;
	}

	public DoubleLinkList padwithZero(DoubleLinkList linklist, int noOfZeroes) {
		DoubleLinkList head = linklist;
		for (int i = 0; i < noOfZeroes; i++) {
			DoubleLinkList n = new DoubleLinkList(0, null, null);
			n.next = head;
			head.prev = n;
			head = n;
		}
		return head;
	}

	private DoubleLinkList insertBefore(DoubleLinkList list,
			int dataToInsertBefore) {
		// TODO Auto-generated method stub
		DoubleLinkList node = new DoubleLinkList(dataToInsertBefore, null, null);
		if (list != null) {
			list.prev = node;
			node.next = list;
		}
		return node;
	}

	public static void main(String[] args) {
		LinkListAddition list = new LinkListAddition();
		// 729
		DoubleLinkList L2 = new DoubleLinkList(2, null, null);
		DoubleLinkList L3 = new DoubleLinkList(9, null, null);
		DoubleLinkList L1 = new DoubleLinkList(7, null, null);
		L1.next = L2;
		L2.prev = L1;
		L2.next = L3;
		L3.prev = L2;
		// 791
		DoubleLinkList L4 = new DoubleLinkList(1, null, null);
		DoubleLinkList L5 = new DoubleLinkList(9, null, null);
		DoubleLinkList L6 = new DoubleLinkList(7, null, null);
		L6.next = L5;
		L5.next = L4;
		L5.prev = L4;

		DoubleLinkList l2 = list.addlist(L1, L6);
		DoubleLinkList l3 = list.add(L1, L6, 0);
		while(l2!=null)
		{
			System.out.println(l2.value);
			l2=l2.next;
		}
		while(l3!=null)
		{
			System.out.println(l3.value);
			l3=l3.next;
		}
	}
}

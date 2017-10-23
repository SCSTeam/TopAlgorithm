package common;

public class ListNode {

	public int val;
	public int value;
//	public int key;
	public ListNode next;
	
	public ListNode(int value) {
		this.val = value;
		this.value = value;
//		this.key = value;
	}
	
	public void print() {
		System.out.print("[ ");
		ListNode head = this;
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.print("]");
	}
}

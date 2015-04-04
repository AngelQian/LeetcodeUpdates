/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int rIndex = 0;
        ListNode temp = head;
        while(temp != null && rIndex<n){
            temp = temp.next;
            rIndex ++;
        }
        
        ListNode temp2 = new ListNode(0);
		temp2.next = head;
		while (temp != null) {
			temp2 = temp2.next;
			temp = temp.next;
		}

		ListNode removeNode = temp2.next;
		if (removeNode == head)
			head = head.next;
		else
			temp2.next = removeNode.next;

		return head;
    }
}
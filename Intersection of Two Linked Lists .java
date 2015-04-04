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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       	ListNode finalA = null;
		ListNode finalB = null;
		ListNode ha = headA;
		ListNode hb = headB;
		if (headA != null && headB != null){
			while (headA != headB) {
				if(headA == null)
					headA = hb;
				else if(headA.next == null){
					finalA = headA;
					headA = headA.next;
				}
				else
					headA = headA.next;

				if(headB == null)
					headB = ha;
				else if(headB.next == null){
					finalB = headB;
					headB = headB.next;
				}
				else
					headB = headB.next;
				
				if (finalA != null && finalB != null && finalA != finalB)
					return null;
			}
    		return headA;
		}
		else
			return null;
    }
}
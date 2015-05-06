/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode ln1 = head;
        ListNode ln2 = head;
        while(ln2!= null && ln2.next!=null && ln2.next.next!=null){
            ln1 = ln1.next;
            ln2 = ln2.next.next;
            if(ln1 == ln2)
               return true;
        }
        return false;
    }
}
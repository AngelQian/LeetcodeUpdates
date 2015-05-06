/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ln = new ListNode(-1), prev;
        ln.next=head;
        prev = ln;
        while(ln!=null && ln.next != null){
            ln = ln.next;
            while(ln!=null && ln.val == val){
                if(ln == head)
                   head=head.next;
                ln = ln.next; 
            }  
            prev.next = ln;
            prev = ln;
            
        }
        return head;
    }
}
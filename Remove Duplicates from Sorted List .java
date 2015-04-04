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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
           return head;
           
        ListNode head1 = new ListNode(0);
        head1.next = head;
           
        ListNode temp = head;
        head = head.next;
        
        while(head!=null){
            if(head.val != temp.val){
                temp.next = head;
                temp = temp.next;
            }else
                temp.next = head.next;
            head = head.next;
        }
        
        return head1.next;
    }
}
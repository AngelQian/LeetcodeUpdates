/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        head.next = l1;
        ListNode cur = head;
        
        int add=0;
        while(l1!=null && l2!=null){
            int n = l1.val+l2.val+add;
            add = n/10;
            l1.val = n%10;
            
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        if(l1 == null){
            cur.next = l2;
            while(l2!=null){
                int n = l2.val+add;
                add = n/10;
                l2.val = n%10;
                
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l2 == null){
            cur.next = l1;
            while(l1!=null){
                int n = l1.val+add;
                add = n/10;
                l1.val = n%10;
                
                cur = cur.next;
                l1 = l1.next;
            }
        }
        if(add > 0)
          cur.next = new ListNode(1);
        
        return head.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode post=null, saved;
        
        while(cur!=null){
            saved = cur.next;
            cur.next=post;
            post=cur;
            cur=saved;
        }
        
        return post;
    }
}
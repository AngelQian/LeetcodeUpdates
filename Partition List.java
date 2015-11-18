/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode cur=head, dummy_small=small, dummy_large=large;
        while(cur!=null){
            if(cur.val<x){
                small.next=cur;
                cur=cur.next;
                small=small.next;
                small.next=null;
            }else{
                large.next=cur;
                cur=cur.next;
                large=large.next;
                large.next=null;
            }
        }
        small.next = dummy_large.next;
        return dummy_small.next;
    }
}
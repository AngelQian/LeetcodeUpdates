/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode helper = new ListNode(0), cur=head, tmp;
        while(cur!=null){
            tmp=helper;
            while(tmp.next!=null && tmp.next.val<cur.val)
                tmp=tmp.next;
            // insert
            ListNode saved = cur.next;
            cur.next=tmp.next;
            tmp.next=cur;
            cur=saved;
        }
        return helper.next;
    }
}
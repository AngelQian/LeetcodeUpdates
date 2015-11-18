/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        //first half, reversed second half, concatenate
        if(head==null || head.next==null)
            return;
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(slow==fast)
            return;
            
        ListNode head2 = slow.next;
        slow.next=null;
        head2 = reverse(head2);
        merge(head, head2);
    }
    private ListNode reverse(ListNode node){
        ListNode tail=null, cur=node;
        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next=tail;
            tail=cur;
            cur=tmp;
        }
        return tail;
    }
    private void merge(ListNode head1, ListNode head2){
        ListNode cur=head1, h1=head1, h2=head2;
        while(h1!=null&&h2!=null){
            ListNode tmp1=h1.next;
            ListNode tmp2=h2.next;
            cur.next=h2;
            cur=cur.next;
            cur.next=tmp1;
            cur=cur.next;
            h1=tmp1;
            h2=tmp2;
        }
    }
}
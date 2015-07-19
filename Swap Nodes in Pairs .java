/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode cur = start;
        while(cur.next!=null && cur.next.next!=null){
            swap(cur);
            cur = cur.next.next;
        }
        return start.next;
    }
    private void swap(ListNode cur){
        //cur->first->second;
        ListNode first = cur.next;
        ListNode second = cur.next.next;
        first.next = second.next;
        second.next = first;
        cur.next = second;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;
        ListNode dummy = new ListNode(0), ancestor=dummy;
        dummy.next=head;
        while(cur!=null){
            if(validate(cur, k)){
                ListNode tail=null, tmp=cur;
                for(int i=k; i>0; i--){
                    ListNode saved = tmp.next;
                    tmp.next=tail;
                    tail=tmp;
                    tmp=saved;
                }
                ancestor.next=tail;
                ancestor=cur;
                cur.next=tmp;
                cur=tmp;
            }else
                break;
        }
        return dummy.next;
    }
    private boolean validate(ListNode node, int k){
        ListNode tmp = node;
        for(int i=k; i>0; i--,tmp=tmp.next){
            if(tmp==null)
                return false;
        }
        return true;
    }
}
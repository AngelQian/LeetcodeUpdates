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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
        //步骤：
        1. 同速度计算相对位移；
        2. 更新慢指针，
        3. 同时出发，返回碰撞点
        // coner case:
        1. 其中一个链表是空
        2. 链表长度相同，交叉在相同Index的位置
        3. 链表长度相同，没有交叉点
        4. 链表长度不相同，（没）有交叉点
        */
        
        if(headA==null || headB==null)
            return null;
            
        //同速度计算相对位移；
        ListNode nd1 = headA, nd2=headB, slow=null , fast=null;
        while(nd1!=null && nd2!=null){
            if(nd1.val == nd2.val)
                return nd1;
            nd1=nd1.next;
            nd2=nd2.next;
        }
        if(nd1==null && nd2==null)
            return null;
            
        ListNode nd = null;
        if(nd1!=null){
            nd=nd1;
            slow=headA;
            fast=headB;
        }
        else if(nd2!=null){
            nd=nd2;
            slow=headB;
            fast=headA;
        }
        int gap=0;    
        while(nd!=null){
            nd=nd.next;
            gap++;
        }
            
        //更新慢指针，
        while(gap>0){
            slow=slow.next;
            gap --;
        }
        
        //同时出发，返回碰撞点
        while(slow!=null && fast!=null && slow.val!=fast.val){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
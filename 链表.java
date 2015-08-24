链表题
Delete Node in a Linked List Total Accepted: 18577 Total Submissions: 41524 My Submissions Question Solution 
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
-------------
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
==================================
Remove Linked List Elements Total Accepted: 27409 Total Submissions: 107671 My Submissions Question Solution 
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
--------------
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
        ListNode nd = new ListNode(-1);
        nd.next=head;
        ListNode cur=head, prev=nd;
        while(cur!=null){
            if(cur.val == val)
            {
                //delete cur
                prev.next=cur.next;
            }else{
                //recodr the previous node
                prev=cur;
            }
            cur=cur.next;
        }
        return nd.next;
    }
}
==========================
Intersection of Two Linked Lists Total Accepted: 40888 Total Submissions: 141163 My Submissions Question Solution 
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
-----------
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
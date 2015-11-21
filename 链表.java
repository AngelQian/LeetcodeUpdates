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
Intersection of Two Linked Lists .java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       	ListNode finalA = null;
		ListNode finalB = null;
		ListNode ha = headA;
		ListNode hb = headB;
		if (headA != null && headB != null){
			while (headA != headB) {
				if(headA == null)
					headA = hb;
				else if(headA.next == null){
					finalA = headA;
					headA = headA.next;
				}
				else
					headA = headA.next;

				if(headB == null)
					headB = ha;
				else if(headB.next == null){
					finalB = headB;
					headB = headB.next;
				}
				else
					headB = headB.next;
				
				if (finalA != null && finalB != null && finalA != finalB)
					return null;
			}
    		return headA;
		}
		else
			return null;
    }
}
==============Add Two Numbers.java
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
Linked List Cycle .java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode ln1 = head;
        ListNode ln2 = head;
        while(ln2!= null && ln2.next!=null && ln2.next.next!=null){
            ln1 = ln1.next;
            ln2 = ln2.next.next;
            if(ln1 == ln2)
               return true;
        }
        return false;
    }
}
Remove Nth Node From End of List.java
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int rIndex = 0;
        ListNode temp = head;
        while(temp != null && rIndex<n){
            temp = temp.next;
            rIndex ++;
        }
        
        ListNode temp2 = new ListNode(0);
		temp2.next = head;
		while (temp != null) {
			temp2 = temp2.next;
			temp = temp.next;
		}

		ListNode removeNode = temp2.next;
		if (removeNode == head)
			head = head.next;
		else
			temp2.next = removeNode.next;

		return head;
    }
}
Remove Linked List Elements .java
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ln = new ListNode(-1), prev;
        ln.next=head;
        prev = ln;
        while(ln!=null && ln.next != null){
            ln = ln.next;
            while(ln!=null && ln.val == val){
                if(ln == head)
                   head=head.next;
                ln = ln.next; 
            }  
            prev.next = ln;
            prev = ln;
            
        }
        return head;
    }
}
Remove Element.java
public class Solution {
    public int removeElement(int[] A, int elem) {
        int i=0,j=0;
        for(;j<A.length;j++)
        {
            if(A[j]!=elem)
              A[i++]=A[j];
        }
        return i;
    }
}
Remove Duplicates from Sorted List .java
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
Remove Duplicates from Sorted Array.java
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<1)
           return 0;
           
        int i=0, j=0;
        for(; j<A.length; j++){
            if(A[i] != A[j])
               A[++i] = A[j];
        }
        return i+1;
    }
}
Remove Duplicates from Sorted Array II 721.java
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2)
            return nums.length;
            
        int j=2;
        for(int i=2; i<nums.length; i++){
            if(nums[i] != nums[j-2]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
Swap Nodes in Pairs .java
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
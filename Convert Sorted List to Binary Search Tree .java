/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode fast = head, mid = head, pre_mid = null;
        if(fast == null) return null;
        if(fast.next == null) return new TreeNode(fast.val);
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            pre_mid = mid;
            mid = mid.next;
        }
        if(pre_mid!=null)
            pre_mid.next = null;
        
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        
        return root;
    }
}
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
        ListNode helper = head; int len=0;
        while(helper !=null){
            len++;
            helper = helper.next;
        }
        
        node = head;
        return  sortedListToBSTHelper(0,len-1);
    }
    private TreeNode sortedListToBSTHelper(int start, int end){
        if(start > end) return null;
        
        int mid = (start+end)/2;
        TreeNode left = sortedListToBSTHelper(start, mid-1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        
        node = node.next;
        
        TreeNode right = sortedListToBSTHelper(mid+1, end);
        root.right = right;
        
        return root;
    }
}
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
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        if(prev!=null)
        {
            prev.left = null;
            prev.right = root;
        }
        prev=root;
        
        TreeNode saveRight = root.right;
        flatten(root.left);
        flatten(saveRight);
    }
}
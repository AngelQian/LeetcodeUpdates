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
    public int countNodes(TreeNode root) {
        int hl=depthLeft(root), hr=depthRight(root);    
        if(hl==hr)
            return (1<<hl) -1;
        else
            return 1+countNodes(root.left)+countNodes(root.right);

    }
    private int depthLeft(TreeNode root){
        if(root==null)
            return 0;
        else    
            return 1+depthLeft(root.left);    
    }
    private int depthRight(TreeNode root){
        if(root==null)
            return 0;
        else    
            return 1+depthRight(root.right);    
    }
}
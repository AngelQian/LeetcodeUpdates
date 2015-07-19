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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn){
        if(startPre>endPre || startIn>endIn)
            return null;
        
        int v = preorder[startPre];
        int len=0;
        for(int i=startIn; i<endIn; i++,len++)
        {
            if(inorder[i]==v)
                break;
        }
            
        TreeNode root = new TreeNode(v);
        root.left = buildTreeHelper(preorder, inorder, startPre+1, startPre+len, startIn, startIn+len-1);
        root.right = buildTreeHelper(preorder, inorder, startPre+len+1, endPre, startIn+len+1, endIn);
        
        return root;
    }
}
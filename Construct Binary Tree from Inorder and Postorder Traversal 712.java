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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int startIn, int endIn, int startPost, int endPost){
        if(startIn>endIn || startPost>endPost)
            return null;
            
        int v = postorder[endPost];
        int len = 0;
        for(int i=startIn; i<=endIn; i++,len++){
            if(inorder[i]==v)
                break;
        }
        
        TreeNode root = new TreeNode(v);  
        root.left = buildTreeHelper(inorder, postorder, startIn, startIn+len-1, startPost, startPost+len-1);
        root.right = buildTreeHelper(inorder, postorder, startIn+len+1, endIn, startPost+len, endPost-1);
        
        return root;
    }
}
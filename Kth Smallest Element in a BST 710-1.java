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
    private int result = 0;
    private int index = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        /*pre-order traverse*/
        kthSmallestHelper(root,k);
        return result;
    }
    
    private void kthSmallestHelper(TreeNode node, int k){
        if(node==null)
            return;
            
        kthSmallestHelper(node.left,k);
        index++;
        if(index==k)
        {
            result = node.val;
            return;
        }
        
        kthSmallestHelper(node.right,k);    
    }
}
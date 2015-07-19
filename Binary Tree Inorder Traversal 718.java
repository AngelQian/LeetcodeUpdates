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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(list, root);
        return list;
    }
    
    private void inorderTraversalHelper( List<Integer> list, TreeNode root){
        if(root == null)
            return;
        
        inorderTraversalHelper( list, root.left);
        list.add(root.val);
        inorderTraversalHelper( list, root.right);
    }
}
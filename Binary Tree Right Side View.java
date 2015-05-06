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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        rightSideViewHelper(root, 0, result);
        return result;
    }
    private void rightSideViewHelper(TreeNode node, int level, List<Integer> result){
        if(node == null)
           return;
        
        if(result.size() == level)
           result.add(node.val);
        
        rightSideViewHelper(node.right, level+1, result);
        rightSideViewHelper(node.left, level+1, result);
    }
}
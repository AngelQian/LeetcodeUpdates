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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrderHelper(root, result, 0);
        return result;
    }
    
    private void zigzagLevelOrderHelper(TreeNode root, List<List<Integer>> result, int level){
        if(root==null)
            return;
        
        List<Integer> path = new ArrayList<>();
        if(result.size() <= level)
            result.add(path);
            
        path = result.get(level);
        if((level&1) == 1)
            path.add(0,root.val); 
        else 
            path.add(root.val); 
        
        zigzagLevelOrderHelper(root.left, result, level+1);    
        zigzagLevelOrderHelper(root.right, result, level+1);    
    }
}
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumHelper(root, sum, result, path);
        return result;
    }
    
    private void pathSumHelper(TreeNode root, int gap, List<List<Integer>> result, List<Integer> path){
        if(root == null)
            return;
            
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(gap==root.val){
                result.add(new ArrayList<>(path));
            }
        }
        
        pathSumHelper(root.left, gap-root.val, result, path);
        pathSumHelper(root.right, gap-root.val, result, path);
        
        path.remove(path.size()-1);
    }
}
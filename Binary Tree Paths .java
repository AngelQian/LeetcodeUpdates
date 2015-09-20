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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        pathHelper(root, result, 0, "");
        return result;
    }
    
    private void pathHelper(TreeNode root, List<String> result, int level, String path){
        if(root==null)
            return;
            
        path += path.length()<1 ? root.val : ("->"+root.val);
            
        if(root.left==null && root.right==null)
            result.add(path);
        
        pathHelper(root.left, result, level+1, path);  
        pathHelper(root.right, result, level+1, path);  
    }
}
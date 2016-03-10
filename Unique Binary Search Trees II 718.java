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
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        return helper(1, n);    
    }
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> subTree = new ArrayList<>();
        if(start>end){
            subTree.add(null);
            return subTree;
        }    
            
        for(int nd=start; nd<=end; nd++){
            List<TreeNode> leftTree = helper(start, nd-1);
            List<TreeNode> rightTree = helper(nd+1, end);
            for(TreeNode left:leftTree){
                for(TreeNode right:rightTree){
                    TreeNode cur = new TreeNode(nd);
                    cur.left = left;
                    cur.right = right;
                    subTree.add(cur);
                }
            }
        }
        return subTree;
    }
}

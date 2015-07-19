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
            return generateTreesHelper(1,0);
        return generateTreesHelper(1,n);
    }
    
    private List<TreeNode> generateTreesHelper(int start, int end){
        List<TreeNode> subTree = new ArrayList<>();
        if(start > end){
            subTree.add(null);
            return subTree;
        }
        
        for(int k=start; k<=end; k++){
            List<TreeNode> leftTree = generateTreesHelper(start, k-1);
            List<TreeNode> rightTree = generateTreesHelper(k+1, end);
            for(TreeNode left : leftTree){
                for(TreeNode right: rightTree){
                    TreeNode node = new TreeNode(k);
                    node.left = left;
                    node.right = right;
                    subTree.add(node);
                }
            }
        }
        
        return subTree;
    }
}
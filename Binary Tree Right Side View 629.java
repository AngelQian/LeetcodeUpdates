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
        rightSideViewHelper(root,result,0);
        return result;
    }
    private void rightSideViewHelper(TreeNode root, List<Integer> list, int level){
        if(root==null)
            return;
            
        if(level == list.size())    
            list.add(root.val);
            
        rightSideViewHelper(root.right, list, level+1);
        rightSideViewHelper(root.left, list, level+1);    
    }
}







       
        
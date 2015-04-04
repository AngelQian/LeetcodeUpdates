/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
           return result;
           
        levelOrderBottomHelper(root,0,result);
        Collections.reverse(result);
        return result;
    }
    
    private void levelOrderBottomHelper(TreeNode root, int level, List<List<Integer>> result){
        if(root == null)
           return ;
           
        List<Integer> li;
        if(result.size()<=level){
            li = new ArrayList<>();
            result.add(li);
        }else
            li = result.get(level);
        li.add(root.val);
        
        levelOrderBottomHelper(root.left, level+1, result);    
        levelOrderBottomHelper(root.right, level+1, result);    
    }
}
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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur=root, pre=null;
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else if(!stack.isEmpty()){
                TreeNode tmp = stack.pop();
                if(pre!=null && pre.val>=tmp.val)
                    return false;
                    
                pre = tmp;  
                cur = tmp.right;  
            }
        }
        return true;
    }
}
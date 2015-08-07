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
    private TreeNode first=null, second=null;
    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        detect(root);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void detect( TreeNode cur){
        if(cur==null)
            return;
        
        detect(cur.left);
        
        if(first==null && pre.val>=cur.val)
            first = pre;
        if(first!=null && pre.val>=cur.val)
            second = cur;
        pre=cur;
        
        detect(cur.right);
    }
}
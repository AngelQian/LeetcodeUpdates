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
    private TreeNode pre = null, tmp = null;
    public void recoverTree(TreeNode root) {
        /*detect(root);*/
        TreeNode nd = root;
        while(nd!=null){
            if(nd.left != null){
                tmp = nd.left;
                while(tmp.right!=null && tmp.right!=nd)
                    tmp = tmp.right;
                
                if(tmp.right!=null){
                    if(pre!=null&&pre.val>nd.val){
                        if(first==null)
                            first = pre;
                        second = nd;    
                    }
                
                    pre = nd;
                    tmp.right = null;
                    nd = nd.right;
                }else{    
                    tmp.right = nd;
                    nd = nd.left;
                }
            }
            else{
                if(pre!=null&&pre.val>nd.val){
                    if(first==null)
                        first = pre;
                    second = nd;    
                }
                pre = nd;
                nd = nd.right;
            }
        }
        
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
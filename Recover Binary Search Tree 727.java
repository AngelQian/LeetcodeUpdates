Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.

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
    private TreeNode nd1=null, nd2=null, pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        
        int val = nd1.val;
        nd1.val = nd2.val;
        nd2.val = val;
    }
    private void traverse(TreeNode cur){
        if(cur==null)
            return;
        traverse(cur.left);
        if(pre.val>=cur.val){
            if(nd1==null)
                nd1=pre;
            if(nd1!=null) // 两个node必须要一一赋值， 防止【1,0】的情况
                nd2=cur;
        }
        pre=cur;
        traverse(cur.right);
    }
}

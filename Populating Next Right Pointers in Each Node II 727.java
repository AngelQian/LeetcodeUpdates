/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        
        TreeLinkNode nd = new TreeLinkNode(-1);
        for(TreeLinkNode cur=root,pre=nd; cur!=null; cur=cur.next){
            if(cur.left!=null){
                pre.next = cur.left;
                pre = pre.next;
            }
            if(cur.right!=null){
                pre.next = cur.right;
                pre = pre.next;
            }
        }
        connect(nd.next);
    }
}
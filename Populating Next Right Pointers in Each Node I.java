Populating Next Right Pointers in Each Node I

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
        TreeLinkNode par = root;
        TreeLinkNode cur, dummy = new TreeLinkNode(0);
        while(par!=null){
            cur=par.left;
            dummy.next=cur;
            while(par!=null && cur!=null){
                if(cur==par.left){
                    cur.next = par.right;
                    par=par.next;
                }else
                    cur.next = par.left;
                cur=cur.next;
            }
            par=dummy.next;
        }
    }
}
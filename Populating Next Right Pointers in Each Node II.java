Populating Next Right Pointers in Each Node II

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
        TreeLinkNode par = root, dummy = new TreeLinkNode(0), cur=dummy;
        while(par!=null){
            if(par.left!=null){
                cur.next=par.left;
                cur=cur.next;
            }
            if(par.right!=null){
                cur.next=par.right;
                cur=cur.next;
            }
            par=par.next;
            if(par==null){
                par=dummy.next;
                cur=dummy;
                cur.next=null;
            }
        }
    }
}
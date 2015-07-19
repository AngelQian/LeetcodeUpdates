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
        TreeLinkNode cur = root;
        while(cur != null){
            TreeLinkNode nextCur = new TreeLinkNode(-1);
            TreeLinkNode helper = nextCur;
            TreeLinkNode move = cur;
            while(move != null){
                if(move.left != null){
                    nextCur.next = move.left;
                    nextCur = nextCur.next;
                }
                
                if(move.right != null){
                    nextCur.next = move.right;
                    nextCur = nextCur.next;
                }
                
                move = move.next;
            }
            cur = helper.next;
        }
    }
}
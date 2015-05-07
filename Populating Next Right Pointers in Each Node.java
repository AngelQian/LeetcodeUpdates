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
        connectHelper(root, null);
    }
    private void connectHelper(TreeLinkNode root, TreeLinkNode sibling){
        if(root == null)  
            return;
        else 
            root.next = sibling;
            
        connectHelper(root.left,root.right);
        if(sibling != null){
            connectHelper(root.right,sibling.left); 
            connectHelper(sibling.left,sibling.right); 
        }
    }
}
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
	//output left child and log right child
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        Stack<TreeNode> sk_right = new Stack<>();
        while(root!=null){
            li.add(root.val);
            if(root.right!=null)
                sk_right.add(root.right);
            root = root.left;
            if(root==null && !sk_right.isEmpty())
                root = sk_right.pop();
        }
        return li;
    }
}
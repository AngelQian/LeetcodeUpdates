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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> sc = new Stack<>();
        while(root!=null){
            result.add(root.val);
            if(root.right!=null)
                sc.push(root.right);
                
            root = root.left;
            if(root==null && !sc.isEmpty())
                root=sc.pop();
        }
        return result;
    }
}
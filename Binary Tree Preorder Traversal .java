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
        // 走左边，存右边， 
        // 边走边存
        //中，左，右
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
            
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            if(tmp.right!=null)
                stack.push(tmp.right);
            if(tmp.left!=null)
                stack.push(tmp.left);
        }
        return result;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            result.add(root.val);
            if(root.right!=null)
                stack.push(root.right);
            root=root.left;
            if(root==null&&!stack.isEmpty())
                root=stack.pop();
        }
        return result;
    }
}

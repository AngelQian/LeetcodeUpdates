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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
            
        Stack<TreeNode> stack = new Stack<>();
        do{
            while(root!=null){
                if(root.right!=null)
                    stack.push(root.right);
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if(root.right!=null && !stack.isEmpty() && root.right==stack.peek()){
                stack.pop();
                stack.push(root);
                root = root.right;
            }else{
                result.add(root.val);
                root=null;
            }
            
        }while(!stack.isEmpty());
        
        return result;
    }
}
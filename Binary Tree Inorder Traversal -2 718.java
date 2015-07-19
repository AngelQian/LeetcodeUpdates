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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> sc = new Stack<>();
        TreeNode nd = root;
        
        while(!sc.isEmpty() || nd!=null){
            if(nd!=null){
                sc.push(nd);
                nd = nd.left;
            }else{
                TreeNode tmp = sc.pop();
                list.add(tmp.val);
                nd = tmp.right;
            }
        }
        
        return list;
    }
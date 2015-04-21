/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        int result = 0;
        return sumNumbersHelper(root,result);
    }
    private int sumNumbersHelper(TreeNode root, int value){
        if(root == null)
           return 0;
           
        value = value*10 + root.val;  
        
        if(root.left==null && root.right==null){
           return value;
        }
           
        return sumNumbersHelper(root.left, value) + sumNumbersHelper(root.right, value);
    }
}
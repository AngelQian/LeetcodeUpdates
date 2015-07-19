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
    private int sum=0;
    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, 0);
        return sum;
    }
    private void sumNumbersHelper(TreeNode root, int num){
        if(root==null)
            return;
            
        num = num*10+root.val;
        if(root.left==null && root.right==null)
            sum+=num;
            
        sumNumbersHelper(root.left,num); 
        sumNumbersHelper(root.right,num); 
    }
}
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }
    private TreeNode sortedArrayToBSTHelper(int[] arr, int first, int last){
        if(first > last) return null;
        
        int mid = (first+last)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedArrayToBSTHelper(arr, first, mid-1);
        root.right = sortedArrayToBSTHelper(arr, mid+1, last);
        return root;
    }
}
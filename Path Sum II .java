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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //larger ? stop : continue;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        pathSumHelper(root,0,path,result,sum);
        return result;
    }
    private void pathSumHelper(TreeNode node, int number, List<Integer> path, List<List<Integer>> result, int total){
        if(node == null) return;
        
        number += node.val;
        path.add(node.val);
        if(node.left==null && node.right==null && number==total){
            result.add(new ArrayList<>(path));
        }
        pathSumHelper(node.left, number, path, result, total);
        pathSumHelper(node.right, number, path, result, total);
        path.remove(path.size()-1);
    }
}
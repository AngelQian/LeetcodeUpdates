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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderHelper(root,0,result);
        return result;
    }
    
    private void levelOrderHelper(TreeNode root, int level, List<List<Integer>> result){
        if (root == null)
			return;

		List<Integer> li;
		if (result.size() <= level) {
			li = new ArrayList<>();
			result.add(level, li);
		} else {
			li = result.get(level);
		}
		li.add(root.val);

		levelOrderHelper(root.left, level + 1, result);
		levelOrderHelper(root.right, level + 1, result);
    }
}
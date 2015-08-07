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
		if (root == null)
			return result;

		Stack<TreeNode> sc = new Stack<>();
		TreeNode nd = root, pre;
		do {
			while (nd != null) {
				sc.push(nd);
				nd = nd.left;
			}

			pre = null;
			while (!sc.isEmpty()) {
				nd = sc.peek();
				if (nd.right == pre) {
					sc.pop();
					result.add(nd.val);
					pre = nd;
				} else {
					nd = nd.right;
					break;
				}
			}
		}while (!sc.isEmpty());
		return result;
    }
}
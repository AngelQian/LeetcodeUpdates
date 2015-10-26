/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode cur;
    private Stack<TreeNode> stack = new Stack<>();
    private Queue<Integer> queue = new LinkedList<>();
    
    public BSTIterator(TreeNode root) {
        cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else if(!stack.isEmpty()){
                TreeNode tmp = stack.pop();
                queue.add(tmp.val);
                if(tmp.right!=null)
                    cur = tmp.right;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
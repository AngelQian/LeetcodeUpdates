public int kthSmallest(TreeNode root, int k) {
        /*pre-order traverse*/
        Stack<TreeNode> sc = new Stack<>();
        
        while(root!=null){
            sc.push(root);
            root = root.left;
        }
        
        while(k!=0){
            k--;
            TreeNode nd = sc.pop();
            if(k==0)
                return nd.val;
                
            TreeNode right = nd.right;    
            while(right!=null){
                sc.push(right);
                right = right.left;
            }
        }
        
        return -1;
    }
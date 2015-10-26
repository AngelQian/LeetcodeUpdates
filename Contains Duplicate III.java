public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
		    return false;
		
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            Integer smaller = tree.floor(num);
            if(smaller!=null && smaller+t>=num)
                return true;
            Integer larger = tree.ceiling(num);
            if(larger!=null && larger-t<=num)
                return true;
                
            tree.add(num);
            if(tree.size()>k)
                tree.remove(nums[i-k]);
        }
        return false;
    }
}

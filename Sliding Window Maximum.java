public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k<1)
            return new int[0];
            
        Deque<Integer> window = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for(int i=0; i<nums.length; ){
            if(window.size()<k){
                window.offerLast(nums[i]);
                i++;
            }
            if(window.size()==k){
                result[i-k]=maxInWindwo(window);
            }
        }
        return result;
    }
    
    private int maxInWindwo(Deque<Integer> window){
        int max=window.pollFirst();
        for(Integer val : window){
        	if(val>max)
        		max=val;
        }
        return max;
    }
}
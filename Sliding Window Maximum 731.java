public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n<1 || k<1)
            return nums;
           
        int ri=0;
        int[] result = new int[n-k+1]; 
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<nums.length; i++){
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            //q stores the index, result stores the value;
            q.add(i);
            if(i>=k-1)
                result[ri++]=nums[q.peek()];
        }
        
        return result;
    }
}
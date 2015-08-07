public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length<1)
            return 1;
            
        for(int i=0; i<nums.length; i++){
            int num=nums[i];
            while(num<=nums.length && num>0 && num!=nums[num-1]){
                //nums[nums[i]-1] <-> nums[i]
                int tmp = nums[i];
                nums[i] = nums[num-1];
                nums[num-1] = tmp;
                num=nums[i];
            }
        }
        
        int i=0;
        while(i<nums.length){
            if(nums[i]!=i+1)
                return i+1;
            i++;    
        }
        
        return nums.length+1;
    }
}
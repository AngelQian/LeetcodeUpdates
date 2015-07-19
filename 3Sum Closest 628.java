public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int nearSum = Integer.MAX_VALUE, sum, result=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1, k=nums.length-1; j<k; ){
                sum = nums[i]+nums[j]+nums[k]; 
                if(Math.abs(sum-target)<nearSum)
                {
                    nearSum=Math.abs(sum-target);
                    result = sum;
                }
                
                if(sum==target)
                    break;
                else if(sum>target)
                    k--;
                else
                    j++;
            }
            while(i+1<nums.length-2 && nums[i+1]==nums[i])
                i++;
        }
        
        return result;
    }
}
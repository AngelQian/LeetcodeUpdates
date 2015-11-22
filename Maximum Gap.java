public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2)
            return 0;
            
        int min=nums[0], max=nums[0];
        for(int i=0; i<nums.length; i++){
          min = Math.min(min, nums[i]);
          max = Math.max(max, nums[i]);
        }
        if(min==max)
            return 0;
            
        int len=(int) Math.ceil((double)(max-min)/(nums.length-1));
        int num=(max-min)/len+1;
        int[] maxArr = new int[num];
        Arrays.fill(maxArr, Integer.MIN_VALUE);
        int[] minArr = new int[num];
        Arrays.fill(minArr, Integer.MAX_VALUE);
        for(int i=0; i<nums.length; i++){
          int index=(nums[i]-min)/len;
          maxArr[index] = Math.max(nums[i], maxArr[index]);
          minArr[index] = Math.min(nums[i], minArr[index]);
        }
        
        int max_gap=0, previous=min;
        for(int i=0; i<num; i++){
			//过滤掉空桶
          if(minArr[i]==Integer.MAX_VALUE && maxArr[i]==Integer.MIN_VALUE)
            continue;
          max_gap=Math.max(max_gap, minArr[i]-previous);
          previous=maxArr[i];
        }
        return max_gap;
  }
}
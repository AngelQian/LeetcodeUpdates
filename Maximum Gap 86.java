public class Solution {
    public int maximumGap(int[] nums) {
        int len = nums.length;
		if (len < 2)
			return 0;

		int min = nums[0], max = nums[0];
		for (int num : nums) {
			min = Math.min(num, min);
			max = Math.max(num, max);
		}

		int[] minArr = new int[len-1], maxArr = new int[len-1];
		Arrays.fill(minArr, Integer.MAX_VALUE);
		Arrays.fill(maxArr, Integer.MIN_VALUE);
		int gap = (int) Math.ceil((double) (max - min) / (len - 1));
		for (int num : nums) {
			if (num == min || num == max)
				continue;
			int index = (num - min) / gap;
			minArr[index] = Math.min(num, minArr[index]);
			maxArr[index] = Math.max(num, maxArr[index]);
		}

		 int maxGap=Integer.MIN_VALUE, previous=min;
		 for(int i=0; i<len-1; i++){
			 if(minArr[i]==Integer.MAX_VALUE && maxArr[i]==Integer.MIN_VALUE)
				 continue;
			 maxGap=Math.max(maxGap, minArr[i]-previous);
			 previous=maxArr[i];
		 }
		 maxGap=Math.max(maxGap, max-previous);
		 
		 return maxGap;
    }
}
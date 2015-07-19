public class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k %= l;
        reverseArr(nums,0,l-k-1);
        reverseArr(nums,l-k, l-1);
        reverseArr(nums,0,l-1);
    }
    private void reverseArr(int[] nums, int startIndex, int endIndex){
        if(startIndex >= endIndex)
            return;
        int mid = (endIndex-startIndex)/2;
    	for(int i=0; i<=mid; i++){
    		int tmp = nums[startIndex+i];
    		nums[startIndex+i] = nums[endIndex-i];
    		nums[endIndex-i] = tmp;
    	}
    }
}
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left=0, right=nums.length-1;
        while(left<=right){
            int pivot = nums[left];
            int tmp=left+1, cur=tmp;
            while(cur<=right){
                if(nums[cur]>pivot)
                {
                    swap(nums, cur, tmp++);
                }
                cur++;
            }
            swap(nums, left, tmp-1);
            
            if(tmp==k)
                return pivot;
            else if(tmp<k)
                left=tmp;
            else
                right=tmp-2;
        }
        return 0;
    }
    
    private void swap(int[]nums, int left, int right){
        if(left<0 || right>=nums.length)
            return;
        int x=nums[left];
        nums[left]=nums[right];
        nums[right]=x;
    }
}
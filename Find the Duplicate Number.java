public class Solution {
    public int findDuplicate(int[] nums) {
        //快慢指针找环，相遇之后，慢指针到环入口的距离=起点到环入口的距离。环入口就是重复的值
        int slow=0, fast=0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        int finder=0;
        do{
            slow = nums[slow];
            finder = nums[finder];
        }while(slow!=finder);
        
        return finder;
    }
}
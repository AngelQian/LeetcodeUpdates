public class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        
        int[] count = new int[32];
        //记录每一比特位出现1的次数
        for(int i=0; i<count.length; i++){
            for(int j=0; j<nums.length; j++){
                int num = nums[j];
                if(((num>>i)&1)==1)
                    count[i] = (count[i]+1)%3;
            }
            result = result|(count[i]<<i);
        }
        
        return result;
    }
}
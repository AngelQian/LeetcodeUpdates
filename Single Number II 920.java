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
---------------optimization : ------------
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length<3)
            return 1;
            
        int val=0;
        for(int i=0; i<32; i++){
            int v=0;
            for(int n=0; n<nums.length; n++){
                v+=((nums[n]>>i)&1);
                v%=3;
            }
            val|=(v<<i);
        }
        return val;
    }
}

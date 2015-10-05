public class Solution {
    public int[] singleNumber(int[] nums) {
       /* 如果对所有元素进行异或操作，最后剩余的结果是出现次数为1次的两个数的异或结果，此时无法直接得到这两个数具体的值。但是，因为这两个数一定是不同的，所以最终异或的值至少有一个位为1。我们可以找出异或结果中第一个值为1的位，然后根据该位的值是否为1，将数组中的每一个数，分成两个部分。这样每个部分，就可以采用Sing number I中的方法得到只出现一次的数。*/
        //get the xor val of two distinct elements;
        int xorAll = 0;
        for(int i=0; i<nums.length; i++)
            xorAll ^= nums[i];
        
        //analyze xor val to get final result;
        int firstBitPos = Integer.highestOneBit(xorAll);
        int num1=0, num2=0;
        for(int num: nums){
            if((num & firstBitPos)==0){
                num1 ^= num;
            }else{
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};    
    }
}
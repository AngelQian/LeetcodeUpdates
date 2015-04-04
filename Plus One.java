public class Solution {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for(int i=digits.length-1; i>=0; i--){
            int v = digits[i]+add;
            add = v/10;
            digits[i] = v%10;
        }
        
        int[] result;
        if(add == 1){
            result = new int[digits.length+1];
            result[0]=1;
            for(int i=1; i<result.length; i++){
                result[i] = digits[i-1];
            }
        }else
        result = digits;
        
        return result;
    }
}
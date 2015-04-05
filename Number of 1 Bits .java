public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int value = 0;
        while(n!=0){
            if((n&1) == 1)
              value ++;
            n >>>= 1;  
        }
        
        return value;
    }
}
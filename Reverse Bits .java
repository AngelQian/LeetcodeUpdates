public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int value = 0;
        for(int i=0; i<32; i++){
            value += n&1;
            n >>>= 1;
            if(i < 31)
               value <<= 1;
        }
        return value;
    }
}
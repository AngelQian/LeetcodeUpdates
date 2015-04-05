public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<32; i++){
            sb.append(n&1);
            n >>>= 1;
        }
        int value = 0;
        for(int i=0; i<sb.length()-1; i++){
        	value += Integer.parseInt(""+sb.charAt(i));
        	value <<=1;
        }
        value += Integer.parseInt(""+sb.charAt(sb.length()-1));
        return value;
    }
}
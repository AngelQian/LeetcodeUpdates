public class Solution {
    public int trailingZeroes(int n) {
        //count the number of 5
        int result = 0;
        while(n/5>=1){
            n = n/5;
            result += n;
        }
        return result;
    }
}
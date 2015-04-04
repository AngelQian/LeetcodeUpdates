public class Solution {
    public boolean isPalindrome(int x) {
        int v = 0;
        int tmp = x;
        while(tmp>0){
            v = v*10+tmp%10;
            tmp/=10;
        }
        return v==x;
    }
}
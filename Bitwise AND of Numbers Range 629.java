public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int result=m;
        int step=0;
        while(m!=n){
            m>>=1;
            n>>=1;
            step++;
        }
        return m<<step;
    }
}
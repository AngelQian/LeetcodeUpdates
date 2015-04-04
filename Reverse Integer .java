public class Solution {
    public int reverse(int x) {
        //INT_MAX (2147483647) or INT_MIN (-2147483648)
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            int tmp = x%10;
            if (Integer.MAX_VALUE / 10 < res) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }

        return sign * res;
    }
}
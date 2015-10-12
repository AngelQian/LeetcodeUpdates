public class Solution {
    public int divide(int dividend, int divisor) {
        long ans = 0;
		long up = Math.abs((long) dividend);
		long down = Math.abs((long) divisor);
		while (up >= down) {
			long tmp = down;
			long count = 1;
			while ((tmp << 1) < up) {
				tmp <<= 1;
				count <<= 1;
			}
			ans += count;
			up -= tmp;
		}
		
		boolean negative = false;
		if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0))
			negative = true;
			
		if(negative)	
		    return ans>Integer.MAX_VALUE ?Integer.MIN_VALUE:(int) -ans;
		else
		    return ans>Integer.MAX_VALUE ?Integer.MAX_VALUE:(int) ans;
    }
}
 public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        
        int result=0;
        if(len <= k){
            for(int i=1; i<len; i++)
                if(prices[i]>prices[i-1])
                    result += prices[i]-prices[i-1];
            return result;        
        }
        
        int[][] f = new int[k+1][len];
        for(int i=1; i<k+1; i++){
            int tmpMax = -prices[0];
            for(int j=1; j<len; j++){
                f[i][j] = Math.max(f[i][j-1], prices[j]+tmpMax);
                tmpMax = Math.max(tmpMax, f[i-1][j-1]-prices[j]);
            }
        }
        
        return f[k][len-1];
    }
}
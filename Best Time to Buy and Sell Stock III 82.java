public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2)
            return 0;
        
        int[] f = new int[len];
        int[] g = new int[len];
        
        for(int i=1, v=prices[0]; i<len; i++){
            v = Math.min(v, prices[i]);
            f[i] = Math.max(f[i-1], prices[i]-v);
        }
        
        for(int i=len-2, v=prices[len-1]; i>=0; i--){
            v = Math.max(v, prices[i]);
            g[i] = Math.max(g[i+1], v-prices[i]);
        }
        
        int max=0;
        for(int i=0; i<len; i++)
            max = Math.max(max, f[i]+g[i]);
        
        return max;    
    }
}

==================================================

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2)
            return 0;
        
        int[][] f = new int[3][len];
        for(int i=1; i<f.length; i++){
            int tmpMax = -prices[0];
            for(int j=1; j<len; j++){
                f[i][j] = Math.max(f[i][j-1], tmpMax+prices[j]);
                tmpMax = Math.max(tmpMax, f[i-1][j-1]-prices[j]);
            }
        }
        
        return f[2][len-1];
    }
}
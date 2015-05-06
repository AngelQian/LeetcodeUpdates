public class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        if(prices.length<1)
          return profit;
          
        int in = prices[0]; 
        for(int i=1; i<prices.length; i++){
            profit = Math.max(profit, prices[i]-in);
            in = Math.min(in, prices[i]);
        }
        return profit;
    }
}
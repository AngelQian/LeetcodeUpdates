public class Solution {
    private int[] f ;
    
    public int numTrees(int n) {
        f = new int[n+1];
        return numTreesHelper(n);
    }
    private int numTreesHelper(int n){
        if(n == 0) return 1;
        if(f[n] > 0 ) return f[n];
        
        int count = 0;
        for(int i=1; i<=n; i++){
            count += numTreesHelper(i-1)*numTreesHelper(n-i);
        }
        f[n] = count;
        
        return count;
        
    }
}
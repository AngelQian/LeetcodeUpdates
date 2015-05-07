public class Solution {
    public int numTrees(int n) {
        if(n<2) return 1;
        
        int[] f = new int[n+1];
        f[0] = 1; f[1] = 1;
        for(int i=2; i<f.length; i++){
            int count = 0;
            for(int k=0; k<i; k++)
              count += f[k]*f[i-1-k];
            f[i] = count;  
        }
        return f[n];
    }
}
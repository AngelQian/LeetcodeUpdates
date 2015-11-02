public class Solution {
    public int numSquares(int n) {
        //Lagrange's four-square theorem: 说明每个正整数均可表示为4个整数的平方和
        //如果一个数除以8余7的话，那么肯定是由4个完全平方数组成
        //由于一个数如果含有因子4，那么我们可以把4都去掉，并不影响结果
        
        int[] f= new int[n+1];
        f[0]=0;
        for(int i=1; i<f.length; i++)
            f[i]=Integer.MAX_VALUE;
        
        for(int i=0; i<f.length; i++){
            for(int j=1; i+j*j<=n; j++){
                f[i+j*j] = Math.min(f[i+j*j], f[i]+1);
            }
        }
        return f[n];    
    }
}
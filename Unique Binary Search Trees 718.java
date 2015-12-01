public class Solution {
    public int numTrees(int n) {
        int[] f = new int[n+1];
        f[0]=f[1]=1;
        for(int i=2; i<=n; i++){
            for(int k=1; k<=i; k++)
                f[i] += f[k-1]*f[i-k];
        }
        return f[n];
    }
   
}
-------------------------OPT
public class Solution {
    public int numTrees(int n) {
        /*f[0]=1;
        f[1]=f[0]*f[0]=1;
        f[2]=f[0]*f[1]+f[0]*f[0]=1+1=2;
        f[3]=f[0]*f[2]+f[1]*f[1]+f[2]*f[0]=1*2+1*1+2*1=5;
        f[4]=f[0]*f[3]+f[1]*f[2]+f[2]*f[1]+f[3]*f[0]=...;*/
        
        int[] f = new int[n+1];
        f[0]=1; 
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                f[i]+=f[j]*f[i-j-1];
            }
        }
        return f[n];
    }
}

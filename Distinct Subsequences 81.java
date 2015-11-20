public class Solution {
    public int numDistinct(String s, String t) {
        //设状态为f(i; j)，表示T[0,j] 在S[0,i] 里出现的次数
        /*
        int[][] f = new int[s.length()+1][t.length()+1];
        for(int i=0; i<f.length; i++)
            f[i][0]=1;
        
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=t.length(); j++){
                f[i][j] = f[i-1][j];
                if(t.charAt(j-1)==s.charAt(i-1))
                    f[i][j]+=f[i-1][j-1];
            }
        }    
        return f[s.length()][t.length()];
        
        */
        int[] f = new int[t.length()+1];
        f[0]=1;
        for(int i=0; i<s.length(); i++){
            for(int j=t.length()-1; j>=0; j--){
                if(t.charAt(j)==s.charAt(i))
                    f[j+1]+=f[j];
            }
        }
        return f[t.length()];
    }
}

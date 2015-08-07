public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())
            return false;
            
        int row = s1.length()+1, col = s2.length()+1;
        boolean[][] f = new boolean[row][col];
        f[0][0]=true;
        
        for(int i=1; i<row; i++)
            f[i][0] = f[i-1][0]&s1.charAt(i-1)==s3.charAt(i-1);
        for(int j=1; j<col; j++)
            f[0][j] = f[0][j-1]&s2.charAt(j-1)==s3.charAt(j-1);
        
        int k=0;
        for(int i=1; i<row; i++)
        {
            for(int j=1; j<col; j++){
                f[i][j] = (f[i-1][j]==true&(s1.charAt(i-1)==s3.charAt(i+j-1)))
                         |(f[i][j-1]==true&(s2.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }
        
        return f[s1.length()][s2.length()];
    }
}
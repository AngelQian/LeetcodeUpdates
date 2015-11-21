Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
        //f[i][j], the steps convert from [0,j] in word2 to [0,i] in word1;
        
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] f = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++)
            f[i][0]=i;
        for(int j=0; j<=word2.length(); j++)
            f[0][j]=j;
            
        for(int i=1; i<=word1.length(); i++)
        {
            for(int j=1; j<=word2.length(); j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    f[i][j]=f[i-1][j-1];
                else{
                    int min = Math.min(f[i][j-1],f[i-1][j]);
                    f[i][j] = Math.min(min,f[i-1][j-1])+1;
                }    
            }
        }
        
        return f[word1.length()][word2.length()];
    }
}

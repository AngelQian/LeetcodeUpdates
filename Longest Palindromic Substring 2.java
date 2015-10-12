public class Solution {
    public String longestPalindrome(String s) {
        int start=0, end=0;
        boolean[][] fun = new boolean[s.length()][s.length()];
        for(int i2=0; i2<s.length(); i2++){
            for(int i1=0; i1<=i2; i1++){
                if(i2==i1)
                    fun[i1][i2]=true;
                else if(s.charAt(i1)==s.charAt(i2)&&(i2==i1+1||fun[i1+1][i2-1]))
                    fun[i1][i2]=true;
                
                if(fun[i1][i2] && i2-i1>end-start){
                    start=i1;
                    end=i2;
                }    
            }
        }
        
        return s.substring(start, end+1);
    }
}
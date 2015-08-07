public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        if(s.length()<2)
            return max;
        
        int len = s.length();    
        int[] f = new int[len];
        
        for(int i=1; i<len; i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='(')
                    f[i] = i<2 ? 2 : f[i-2]+2;
                 else{//combine previous parentheses
                    int index = i-1-f[i-1];
                    if(index>=0 && s.charAt(index)=='(')
                        f[i] = f[i - 1] + 2 + ((index - 1 >= 0)?f[index - 1]:0);
                }
                max = Math.max(max, f[i]);
            }
        }
        
        return max;
    }
}
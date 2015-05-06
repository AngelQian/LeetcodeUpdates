public class Solution {
    public String longestPalindrome(String s) {
        String result = ""; int start=0,end=0;
		boolean[][] f = new boolean[s.length()][s.length()];
		for(int j=0; j<s.length(); j++){
		    for(int i=0; i<=j; i++){
		        f[i][j] = (s.charAt(i)==s.charAt(j))&&(j-i<2 || f[i+1][j-1]);
		        if(f[i][j] && j-i+1 > end-start)
		        {
		            start = i; end = j+1;
		        }
		    }
		}
		return s.substring(start, end);
    }
}
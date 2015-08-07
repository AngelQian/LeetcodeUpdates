public class Solution {
    public int minCut(String s) {
        int[] cut = new int[s.length()+1];
        for(int i=0; i<cut.length; i++)
            cut[i]=s.length()-i-1;
            
        boolean[][] f = new boolean[s.length()][s.length()];
        for(int i=s.length()-1; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<2 || f[i+1][j-1]==true){
                        f[i][j] = true;
                        cut[i] = Math.min(cut[i], cut[j+1]+1);
                    }
                }
            }
        }
        
        return cut[0];
    }
}
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0]=true;
        for(int j=1; j<f.length; j++){
            for(int i=1; i<=j; i++){
                String str = s.substring(i-1, j);
                if(wordDict.contains(str) && f[i-1])
                    f[j]=true;
            }
        }
        return f[len];
    }
}

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length()+1;
        boolean[] f=new boolean[len];
        f[0]=true;
        
        for(int end=1; end<=s.length(); end++){
            for(int start=0; start<end; start++){
                if(f[start] && wordDict.contains(s.substring(start,end))){
                    f[end]=true;
                    break;
                }
            }
        }
        
        return f[len-1];
    }
}
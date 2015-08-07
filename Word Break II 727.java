public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        
       int len = s.length();
        boolean[] f = new boolean[len];
        for(int i=0; i<len; i++){
            for(int j=0; j<=i; j++){
                String sub = s.substring(j, i+1);
                if(wordDict.contains(sub) && (j==0||f[j-1]))
                {
                    f[i]=true;
                    break;
                }
            }
        }
        if(f[len-1]==false)
            return result;
        
        wordBreakHelper(s, wordDict, result, 0, "");
        return result;
    }
    
    private void wordBreakHelper(String s, Set<String> wordDict, List<String> result, int index, String path){
        if(index == s.length()){
            result.add(path);
            return;
        }
        
        for(int i=index; i<s.length(); i++){
             String sub = s.substring(index, i+1);
                if(wordDict.contains(sub)){
                    String space = path.length()==0?"":" ";
                    wordBreakHelper(s, wordDict, result, i+1, path+space+sub);
                }
        }
    }
}
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionHelper(s,result,0,path);
        return result;
    }
    
    private void partitionHelper(String s, List<List<String>> result, int start, List<String> path){
        if(start==s.length()){
            result.add(new ArrayList<>(path));
        }    
        for(int i=start; i<s.length();i++){
            String sub = s.substring(start,i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                partitionHelper(s,result,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        for(int i=0, j=s.length()-1; i<j; i++,j--)
            if(s.charAt(i)!=s.charAt(j))
                return false;
        return true;        
    }
}
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
		Set<Integer> set = new HashSet<Integer>();
		return dfs(s, dict, 0, set);
	}

	private boolean dfs(String s, Set<String>dict, int start, Set<Integer> set){
        if(start == s.length())
           return true;
        if(set.contains(start))
           return false;
           
        for(int i=start+1; i<=s.length();i++){
            String sub = s.substring(start,i);
            if(dict.contains(sub))
               if(dfs(s,dict,i,set))
                  return true;
                else
                set.add(i);
        }   
        set.add(start);
        return false;
    }
}
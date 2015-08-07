public class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if(s.isEmpty() || t.isEmpty())
            return result;
            
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            hm.put(c, hm.containsKey(c) ? hm.get(c)+1 : 1);
        }
        
        int minLen=Integer.MAX_VALUE;
        int lettercount = 0;
        HashMap<Character, Integer> cur = new HashMap<>();
        for(int slow=0,fast=0; fast<s.length(); fast++){
            char c=s.charAt(fast);
            if(hm.containsKey(c)){
                cur.put(c,cur.containsKey(c)?cur.get(c)+1 : 1);
                if(cur.get(c)<=hm.get(c))
                    lettercount ++;
            }
            if(lettercount >= t.length()){
                char cc = s.charAt(slow);
                while(!hm.containsKey(cc) ||cur.get(cc)>hm.get(cc))
                {
                    if(cur.containsKey(cc))
                    	cur.put(cc, cur.get(cc)-1);
                    slow++;
                    cc = s.charAt(slow);
                }
                
                if(fast-slow+1 < minLen){
                    minLen = fast-slow+1;
                    result = s.substring(slow,slow+minLen);
                }
            }
        }
        
        return result;
    }
}
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
           return false;
           
        HashMap<Character,Integer> hm_s = new HashMap<>();
        HashMap<Character,Integer> hm_t = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character cs = s.charAt(i);
            Character ct = t.charAt(i);
            if(hm_s.containsKey(cs)&&hm_t.containsKey(ct)){
                if(hm_s.get(cs) == hm_t.get(ct))
                  continue;
                else 
                  return false;
            }else if(!hm_s.containsKey(cs) && !hm_t.containsKey(ct)){
                hm_s.put(cs,i);
                hm_t.put(ct,i);
            }else
                return false;
        }
        return true;
    }
}
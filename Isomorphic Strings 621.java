public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(!hm1.containsKey(c1) && !hm2.containsKey(c2))
            {
                hm1.put(c1,i);
                hm2.put(c2,i);
            }else{
                if(hm1.get(c1) != hm2.get(c2))
                    return false;
            }
        }
        return true;
    }
}
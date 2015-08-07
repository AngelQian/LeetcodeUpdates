public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words.length<1)
            return result;
        
        int wordLen = words[0].length();    
        int catLen = wordLen*words.length;
        if(s.length()<catLen)
            return result;
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(String word: words)
            hm.put(word, hm.containsKey(word)?hm.get(word)+1:1);
        
        for(int i=0; i+catLen<=s.length(); i++){
            HashMap<String, Integer> unused = new HashMap<>(hm);
            for(int j=i; j<i+catLen; j+=wordLen){
                String sub = s.substring(j, j+wordLen);
                if(!unused.containsKey(sub) || unused.get(sub)==0)
                    break;
                    
                if(unused.get(sub)>0)
                    unused.put(sub, unused.get(sub)-1);
                if(unused.get(sub)==0)
                	unused.remove(sub);    
            }
            if(unused.size()==0)
                result.add(i);
        }    
        
        return result;
    }
}
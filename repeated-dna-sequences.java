
	
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashSet<Integer> words = new HashSet<>();
        HashSet<Integer> doublewords = new HashSet<>();
        
        for(int i=0; i<s.length()-9; i++)
        {
            String sub = s.substring(i,i+10);
            int v = convert(sub);
            if(!words.add(v) && doublewords.add(v))
                result.add(sub);
        }
        
        return result;
    }
    
    public int convert (String sub){
        int res = 0;
        HashMap<Character, Integer> dict = new HashMap<>();
        dict.put('A',0); dict.put('C',1);
        dict.put('G',2); dict.put('T',3);
        for (int i = 0; i< 10; ++i ){
            res+=dict.get(sub.charAt(i)); 
            res*=4;
        }
        return res;
    }
}	
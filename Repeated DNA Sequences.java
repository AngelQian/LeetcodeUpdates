public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('A',0);
        hm.put('C',1);
        hm.put('G',2);
        hm.put('T',3);
        
        for(int i=0; i<s.length()-9; i++)
        {
            String s1 = s.substring(i,i+10);
            int id = convertToId(s1,hm);
            if(hs.contains(id)){
                if(!result.contains(s1))
                    result.add(s1);
            }else
              hs.add(id);
        }
        
        return result;
    }
    private int convertToId(String s, HashMap<Character, Integer> hm){
        int id=0;
        for(int i=0; i<10; i++){
            id+=hm.get(s.charAt(i));
            id*=4;
        }
        return id;
    }
}
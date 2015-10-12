public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //compute hash code for 10 characters
        //store & compare hash code, get result
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<s.length()-9; i++){
            String subStr = s.substring(i,i+10);
            int hashNum = convert(subStr);
            if(map.containsKey(hashNum) && !map.get(hashNum)){
                    result.add(subStr);
                    map.put(hashNum,true);
            }
            else if(!map.containsKey(hashNum))
                map.put(hashNum,false);
        }
        
        return result;
    }
    
    private int convert(String str){
        HashMap<Character,Integer> dict = new HashMap<>();
        dict.put('A',1);
        dict.put('C',2);
        dict.put('G',3);
        dict.put('T',0);
        
        int v=0;
        for(int i=0; i<str.length(); i++){
            v = v*4+dict.get(str.charAt(i));
        }
        
        return v;
    }
}
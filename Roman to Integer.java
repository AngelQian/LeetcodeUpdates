public class Solution {
    public int romanToInt(String s) {
        //小大 -> 大-小
        //大小/大大/小小 -> 大+小 
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        if(s.isEmpty())
            return 0;
            
        int value = 0, cur=0, pre=0;
        for(int i=0; i<s.length(); i++){
            cur = map.get(s.charAt(i));
            if(i>0){
                pre = map.get(s.charAt(i-1));
                if(cur>pre){
                    value = value-pre+(cur-pre);
                    continue;
                }
            }
            value += cur;
        }
        
        return value;
    }
}
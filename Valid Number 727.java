public class Solution {
    public boolean isNumber(String s) {
        if(s.trim().isEmpty())
            return false;
        
        String REG="[+-]?(\\d+\\.?|\\.\\d+)\\d*(e[+-]?\\d+)?";
        return (s.trim().matches(REG));
    }
}
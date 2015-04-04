public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1)
        return "";
        
        String first = strs[0];
        int strIndex = 1;
        while(strIndex < strs.length){
            while(strs[strIndex].indexOf(first) != 0){
                first = first.substring(0,first.length()-1);
            }
            strIndex ++;
        }
        return first;
    }
}
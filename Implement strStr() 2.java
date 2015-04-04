public class Solution {
    public int strStr(String haystack, String needle) {
        int h=haystack.length(), n=needle.length(); 
        if(n>h)
          return -1;
        if(n==h)
          return needle.equals(haystack) ? 0 :-1;
        if(n<1)
          return 0;
        
        for(int i=0; i<=h-n; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                String sub = haystack.substring(i, i+n);
                if(sub.equals(needle))
                   return i;
            }
        }
        
        return -1;
    }
}
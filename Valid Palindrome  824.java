public class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        for(int i=0, j=s.length()-1; i<=j; i++, j--){
            char start = s.charAt(i);
            while(i<s.length()-1 && !Character.isLetter(start) && !Character.isDigit(start)){
                i++;
                start = s.charAt(i);
            }
            
            char end = s.charAt(j);
            while(j>0 && !Character.isLetter(end) && !Character.isDigit(end)){
                j--;
                end = s.charAt(j);
            }
            if(i>=j)
                return true;
                
            if(Character.toLowerCase(start) != Character.toLowerCase(end))
                return false;
        }
        
        return true;
    }
}
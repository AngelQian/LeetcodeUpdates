public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb1 = new StringBuilder();
        String s2 = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)||Character.isDigit(c)){
                sb1.append(Character.toLowerCase(c));
            }
        }
        s2 = sb1.toString();
        sb1.reverse();
        return sb1.toString().equals(s2);
    }
}
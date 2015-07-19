public class Solution {
    public String reverseWords(String s) {
        String[] arr_ss = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=arr_ss.length-1; i>=0; i--){
            if(arr_ss[i].trim().length()>0)
        	    sb.append(arr_ss[i].trim()+" ");
        }
        
        return sb.toString().trim();
    }
}
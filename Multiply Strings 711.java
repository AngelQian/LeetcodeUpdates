public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2=num2.length();
        int[] result = new int[len1+len2];
        for(int i=len1-1; i>=0; i--){
            int carry = 0;
            for(int j=len2-1; j>=0; j--){
                int tmp = result[i+j+1] + (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+carry;
                result[i+j+1] = tmp%10;
                carry = tmp/10;
            }
            result[i] += carry;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.length; i++){
            if(sb.length()==0 && result[i]==0)
                continue;
            sb.append(result[i]);    
        }
        
        return sb.length()==0 ? ""+0 : sb.toString();
    }
}
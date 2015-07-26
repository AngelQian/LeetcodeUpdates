public class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1; i>=0; i--){
            int carry=0;
            for(int j=num2.length()-1; j>=0; j--){
                int n1=num1.charAt(i)-'0', n2=num2.charAt(j)-'0';
                int tmp = result[i+j+1]+n1*n2+carry;
                result[i+j+1] = tmp%10;
                carry = tmp/10;
            }
            result[i] += carry;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int x:result){
            if(sb.length()<1 && x==0)
                continue;
            sb.append(x);
        }
        
        return sb.length()<1 ? "0" : sb.toString();    
    }
}
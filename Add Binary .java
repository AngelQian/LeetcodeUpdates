public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int add = 0;
        int i=a.length()-1, j=b.length()-1;
        while(i>=0&&j>=0){
            int xa  = a.charAt(i--)-'0';
            int xb = b.charAt(j--)-'0';
            int v = xa+xb+add;
            sb.append(v%2);
            add = v/2;
        }
        
        while(i>=0){
            int xa  = a.charAt(i--)-'0';
            int v = xa+add;
            sb.append(v%2);
            add = v/2;
        }
        
        while(j>=0){
            int xb  = b.charAt(j--)-'0';
            int v = xb+add;
            sb.append(v%2);
            add = v/2;
        }
        
        if(add>0)
            sb.append(1);
        return sb.reverse().toString();
    }
}
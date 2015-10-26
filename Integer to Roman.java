public class Solution {
    public String intToRoman(int num) {
       int[] factors = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  
       String[] values = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
       
       StringBuilder builder = new StringBuilder();
       for(int i=0; num>0; num%=factors[i++]){
           int n = num/factors[i];
           while(n>0){
               builder.append(values[i]);
               n--;
           }
       }
       return builder.toString(); 
    }
}
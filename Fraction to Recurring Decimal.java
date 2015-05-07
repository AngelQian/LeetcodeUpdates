public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(((numerator<0 && denominator>0)||(numerator>0 && denominator<0)) ? "-" : ""); 
       
        long mod = num%den;
        long result = num/den;
        sb.append(result);
        if(mod==0)
          return sb.toString();
        
        sb.append(".");
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(mod,sb.length());
        
        while(mod!=0){
            num = Math.abs(mod*10);
            result = num/Math.abs(den);
            sb.append(result);
            
            mod = num%den;
            if(map.containsKey(mod)){
                int i = map.get(mod);
                sb.insert(i,"(");
                sb.append(")");
                break;
            }
            else
               map.put(mod,sb.length());
        }
        
        return sb.toString();
    }
}
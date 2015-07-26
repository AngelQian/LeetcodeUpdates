public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(numerator<0&&denominator>0 || numerator>0&&denominator<0)
            sb.append("-");
            
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long result = num/den;
        long mod = num%den;
        
        sb.append(result);
        if(mod==0)
            return sb.toString();
        
        sb.append(".");
        
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(mod,sb.length());
        
        while(mod!=0){
            sb.append(mod*10/den);
            mod=(mod*10)%den;
            
            if(hm.containsKey(mod)){
                int pos = hm.get(mod);
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }else
                hm.put(mod,sb.length());
        }
        return sb.toString();
    }
}
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean sign = (numerator>=0&&denominator>0) || (numerator<=0&&denominator<0);
        long up = Math.abs((long)numerator);
        long down = Math.abs((long)denominator);
        
        StringBuilder builder = new StringBuilder();
        long value = up/down;
        builder.append(value);
        if(up%down==0)
            return sign ? builder.toString() : builder.insert(0,"-").toString();
           
        builder.append(".");    
        up -= value*down;
        HashMap<Long, Integer> map = new HashMap<>();
        while(up<down || !map.containsKey(up)){
            long tmp = (up*10)/down;
            if(map.containsKey(up)){
            	builder.insert(map.get(up), "(").append(")");
                break;
            }
            map.put(up, builder.length());
            builder.append(tmp);
            up = up*10 - tmp*down;
            if(up==0)
                break;
        }
        
        return sign ? builder.toString() : builder.insert(0,"-").toString();
    }
}
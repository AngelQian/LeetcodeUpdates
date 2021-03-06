public class Solution {
    public int numDecodings(String s) {
        int[] f = new int[s.length()+1];
        if(s.length()<1)
            return 0;
            
        f[0]=1;
        for(int i=1; i<f.length; i++){
            if(s.charAt(i-1)!='0')
                f[i] = f[i-1];
                
            if(i>1){
                Integer num = Integer.parseInt(s.substring(i-2, i));
                if(num>=10 && num<=26)
                    f[i] += f[i-2];
            }    
        }
        return f[s.length()];
    }
}

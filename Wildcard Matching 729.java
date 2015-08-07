public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        int count=0;
        for(int i=0; i<plen; i++){
            if(p.charAt(i)=='*')
                count++;
        }
        if(count==0 && slen!=plen)
            return false;
        if(plen-count>slen)
            return false;
        
        boolean[] f = new boolean[slen+1];
        f[0]=true;
        for(int i=0; i<plen; i++){
            if(p.charAt(i)=='*'){
                for(int j=0; j<slen; j++)
                    f[j+1] = f[j]/*|f[j+1]*/;
            }else{
                for(int j=slen-1; j>=0; j--)
                    f[j+1] = (p.charAt(i)=='?' || s.charAt(j)==p.charAt(i))&f[j];
                f[0]=false;
            }
        }
        
        return f[slen];
    }
}
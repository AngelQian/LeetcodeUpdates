public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        String ip="";
        dfs(s,0,0,ip,result);
        return result;
    }
    
    private void dfs(String s, int start, int step, String ip, List<String> result){
        if(start == s.length() && step==4)
        {
            result.add(ip.substring(0,ip.length()-1));
            return;
        }
        if(s.length()-start > (4-step)*3)
           return;
        if(s.length()-start < 4-step)
           return;
        
        int num=0;
        for(int i=start; i<start+3 && i<s.length(); i++){
            char c = s.charAt(i);
            num = num*10+(c-'0');
            
            if(num<=255){
               ip += c;
               dfs(s,i+1,step+1,ip+'.',result);
            }
            if(num==0)
            break;
        }
    }
}
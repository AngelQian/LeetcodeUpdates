public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(0, 0, s, "", result);
        return result;
    }
    
    private void restoreIpAddresses(int index, int step, String s, String path, List<String> result){
        if(index==s.length() && step==4){
            String str = path.substring(0,path.length()-1);
            result.add(str);
            return;
        }
        if(s.length()-index>(4-step)*3)
            return;
        if(s.length()-index<(4-step))
            return;
        
        for(int i=index; i<index+3 && i<s.length(); i++){
            String sub = s.substring(index, i+1);
            int num = Integer.valueOf(sub);
            if((sub.charAt(0)=='0'&& num!=0) || (sub.length()>1&&num==0) || num>255)
                return;
            restoreIpAddresses(i+1, step+1, s, path+sub+".", result);
        }
    }
}

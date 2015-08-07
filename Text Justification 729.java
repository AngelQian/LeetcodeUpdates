public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        for(int start=0, cur=0; cur<words.length; start=cur){
            
            //identify how many words can fit in
            int len=words[cur++].length();
            while(cur<words.length && len+1+words[cur].length()<=maxWidth){
                len += 1+words[cur++].length();
            }
            
            //identify how many even gaps needed
            //corner case: last line
            int space=1, extra=0;
            if(cur!=start+1 && cur!=words.length){
                space=(maxWidth-len)/(cur-start-1) + 1;
                extra=(maxWidth-len)%(cur-start-1);
            }
            
            //fill space
            StringBuilder sb = new StringBuilder(words[start]);
            for(int i=start+1; i<cur; i++){
                for(int s=0; s<space; s++)
                {
                    sb.append(" ");
                }
                if(extra>0){
                    sb.append(" ");
                    extra--;
                }
                sb.append(words[i]);
            }
            
            //coner case: one word left
            int rest = maxWidth-sb.length();
            while(rest>0){
                sb.append(" ");
                rest --;
            }
            
            result.add(sb.toString());
        }
        
        return result;
    }
}
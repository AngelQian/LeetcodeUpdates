public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
		boolean[] f=new boolean[s.length()+1];
		f[0]=true;
		for(int i=1; i<=s.length(); i++)
		  for(int j=i-1; j>=0; j--)
		     if(f[j] && dict.contains(s.substring(j,i))){
		        f[i]=true;
		        break;
		     }
		 return f[s.length()];    
    }
}
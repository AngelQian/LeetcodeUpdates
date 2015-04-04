public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1)
        return "";
        
        StringBuilder result = new StringBuilder();
		int strIndex = 1, charIndex = 0;
		while(charIndex < strs[0].length()){
			char c = strs[0].charAt(charIndex);
			while(strIndex < strs.length){
				if(charIndex >= strs[strIndex].length() || strs[strIndex].charAt(charIndex)!=c)
					break;
				else
					strIndex ++;
			}
			
			if(strIndex == strs.length){
				charIndex ++;
				result.append(c);
				strIndex = 1;
			}else
				break;
		}
		
		return result.toString();
    }
}
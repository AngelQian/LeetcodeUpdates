public class Solution {
    public String shortestPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();
		int cur, head, tail, len = s.length();
		
		if(len<1)
		    return sb.toString();
		
		for (cur = head = tail = len/2; cur >= 0; head = tail = --cur){
			while(head>0 && s.charAt(head-1)==s.charAt(head))
			{
				head --; cur --;
			}
			
			while(tail<len-1 && s.charAt(tail+1)==s.charAt(tail))
			{
				tail ++;
			}
			
			boolean isSame = true;
			while(head>=0){
				if( tail >= s.length() || s.charAt(head) != s.charAt(tail)){
					isSame = false;
					break;
				}
				head --; tail ++;
			}
			if(isSame)
				break;
		}
		
		for(int i=len-1; i>=tail && i!=0; i--)
			sb.append(s.charAt(i));
		
		return sb.append(s).toString();
    }
}
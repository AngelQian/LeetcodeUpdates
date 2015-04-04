public class Solution {
    public int atoi(String str) {
        String s = str.trim(); 
		int neg = 1;
		int result = 0;
		int sigcount = 0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				int tmp = Integer.parseInt(""+c);
				if (result > Integer.MAX_VALUE / 10)
					return neg < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				else if (result == Integer.MAX_VALUE / 10)
					if (tmp >= 7 && neg > 0)
						return Integer.MAX_VALUE;
					else if (tmp >= 8 && neg < 0)
						return Integer.MIN_VALUE;
				result = result*10+tmp;
			}else{
			    if(i==0){
			        if(c == '-')
		    	        neg = -1;
			        else if(c != '+')
			            return 0;
			    }else
				   break;	
			}
		}
		return result*neg;
    }
}
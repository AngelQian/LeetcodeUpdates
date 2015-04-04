public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
           return false;
        if(x<10)
           return true;
           
        int len = 1;
        int tmp = x;
        while(tmp/10!=0){
          len++;
          tmp /= 10;
        }
        
        while(x!=0){
            int tp = (int)(Math.pow(10,--len));
            int t = x%10;
            int h = (int)(x/tp);
            if(t != h)
              return false;
            x -= h*tp;
            x /= 10;
            len --;
            
            if(x>0 && x<10)
                return len == 1?true:false;
        }
        
        return true;
    }
}
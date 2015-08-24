public class Solution {
    public boolean isHappy(int n) {
        int slow=n, fast=n;
        do{
            slow = next(slow);
            fast = next(next(fast));
        }while(slow!=fast);
        
        return slow==1;
    }
    
    private int next(int n){
        int number=0;    
        while(n!=0){
            int x=n%10;
            number += x*x;
            n/=10;
        }
        return number;
    }
}

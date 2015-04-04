/*public class Solution {
    public int climbStairs(int n) {
        if(n==1)
          return 1;
        if(n==2)
          return 2;
        return climbStairs(n-1)+ climbStairs(n-2); 
    }
}
*/

public class Solution {
    public int climbStairs(int n) {
        if(n<3)
          return n;
          
        int[] cs = new int[n+1];
        cs[0]=0; 
        cs[1]=1;
        cs[2]=2;
        
        for(int i=3; i<cs.length; i++){
            cs[i]=cs[i-1]+cs[i-2];
        }
        
        return cs[n];
    }
}

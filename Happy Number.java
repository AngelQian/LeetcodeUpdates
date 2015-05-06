public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        int sum=n;
        while(!hs.contains(sum)){
            hs.add(sum);
            
            int x=sum, s=0;
            while(x>0){
                int y = x%10;
                s += y*y;
                x = x/10;
            }
            sum=s;
        }
        return sum == 1;
    }
}
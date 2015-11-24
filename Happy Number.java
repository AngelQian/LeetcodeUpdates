Happy Number

public class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        while(!map.containsKey(n)){
            int tmp = getSquareSum(n);
            map.put(n, tmp);
            n=tmp;
        }
        return n==1;
    }
    
    private int getSquareSum(int n){
        int sum=0;
        while(n>0){
            int tmp=n%10;
            sum += tmp*tmp;
            n/=10;
        }
        return sum;
    }
}

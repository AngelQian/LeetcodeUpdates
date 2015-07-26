public class Solution {
    public int mySqrt(int x) {
        int left=1, right=x/2, last_mid=0;
        if(x<2)
            return x;
        while(left<=right){
            int mid = (left+right)/2;
            int num = x/mid;
            if(num == mid){
                return num;
            }else if(num>mid){
                left = mid+1;
                last_mid = mid;
            }else
                right = mid-1;
        }    
        
        return last_mid;
    }
}
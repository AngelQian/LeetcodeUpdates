public class Solution {
    public int singleNumber(int[] A) {
        if(A.length<1)
           return 0;
           
        int value = A[0];   
        for(int i=1; i<A.length; i++)
           value ^= A[i];
        return value;   
    }
}
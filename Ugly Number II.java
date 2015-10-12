public class Solution {
    public int nthUglyNumber(int n) {
        /*
        (1) 1×2, 2×2, 3×2(重复), 4×2, 5×2, …
        (2) 1×3, 2×3(重复), 3×3, 4×3, 5×3, …
        (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
        */
        int[] f = new int[n];
        f[0]=1;
        
        int cur2=2, cur3=3, cur5=5;
        int index2=1, index3=1, index5=1;
        for(int i=1; i<n; i++){
            int minCur = Math.min(Math.min(cur2,cur3),cur5);
            f[i] = minCur;
            if(minCur==cur2){
                cur2 = 2*f[index2];
                index2++;
            }
            if(minCur==cur3){
                cur3 = 3*f[index3];
                index3++;
            }
            if(minCur==cur5){
                cur5 = 5*f[index5];
                index5++;
            }
        }
        
        return f[n-1];
    }
}
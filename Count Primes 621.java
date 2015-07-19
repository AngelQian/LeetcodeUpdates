public class Solution {
    public int countPrimes(int n) {
        int v=0;
        boolean[] helper = new boolean[n];
        for(int i=2; i<n; i++){
            if(helper[i] == false){
                v++;
                for(int j=i*2; j<n; j+=i)
                    helper[j]=true;
            }
        }
        return v;
    }
    
}
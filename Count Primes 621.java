public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count=0;
        for(int i=2; i<n; i++){
            if(notPrimes[i]==true)
                continue;
            count++;
            for(int j=i*2; j<n; j+=i)
                notPrimes[j]=true; //j=4->6->8->10->12
        }
        return count;
    }
}

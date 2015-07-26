public class Solution {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i=1; i<=n; i++)
            nums.add(i);
        
        int[] fractions = new int[n];
        fractions[0]=1;
        for(int i=1; i<n; i++)
            fractions[i] = fractions[i-1]*i;
        
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0; i--){
            int index = k/fractions[i];
            k %= fractions[i];
            sb.append(nums.get(index));
            nums.remove(index);
        }
        
        return sb.toString();
    }
}
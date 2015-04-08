public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        for(int i=0; i<num.length-2; i++){
            for(int j=i+1, k=num.length-1; j<k;){
                if(num[i]+num[j]+num[k]==0){
                    result.add(Arrays.asList(num[i],num[j],num[k]));
                    while(j<k && num[j+1]==num[j]) j++;
                    while(j<k && num[k-1]==num[k]) k--;
                    j++; k--;
                }else if(num[i]+num[j]+num[k]>0)
                    k--;
                else
                    j++;
            }
            
            while(i+1<num.length-2 && num[i+1]==num[i])
                i++;
        }
        return result;
    }
}
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        for(int i=0; i<num.length-2; i++){
            for(int j=i+1; j<num.length-1; j++){
                //search k
                int need_value = 0-num[i]-num[j];
                if(need_value < num[j])
                    break;
                int k = Arrays.binarySearch(num,j+1,num.length,need_value);
                if(k>j){
                    result.add(Arrays.asList(num[i],num[j],num[k]));
                }
                
                while(j+1<num.length-1 && num[j+1]==num[j])
                     j++;
            }
            
            while(i+1<num.length-2 && num[i+1]==num[i])
                i++;
        }
        return result;
    }
}
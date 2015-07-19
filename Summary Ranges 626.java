public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<nums.length;){
            int j=i+1; StringBuilder sb = new StringBuilder();
            int first = nums[i];
            sb.append(first);
            
            while(j<nums.length && nums[j]==nums[i]+1){
                j++; i++;
            }
            
            if(first != nums[i])
                sb.append("->").append(nums[i]);
            
            result.add(sb.toString());
            i=j;
        }
        return result;
    }
}
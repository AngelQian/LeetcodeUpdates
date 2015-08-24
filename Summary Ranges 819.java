public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        
        if(nums.length<1)
            return result;
        
        if(nums.length==1){ 
            builder.append(nums[0]);
            result.add(builder.toString());
            return result;
        }
        
        for(int i=0, j=i; i<nums.length; i=j+1){
            
            for(j=i; j+1<nums.length && nums[j+1]==nums[i]+j+1-i; j++);
            
            builder.append(nums[i]);
            if(j!=i)
                builder.append("->").append(nums[j]);
            
            result.add(builder.toString());
            builder=new StringBuilder();
        }
        
        
        return result;
    }
}
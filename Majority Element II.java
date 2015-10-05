public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1=0, count1=0, candidate2=0, count2=0;
        for(int i=0; i<nums.length; i++){
            if(count1==0){
                candidate1=nums[i];
                count1++;
            }else if(nums[i]==candidate1){
                count1++;
            }else if(count2==0){
                candidate2=nums[i];
                count2++;
            }else if(nums[i]==candidate2){
                count2++;
            }
            
            if(nums[i]!=candidate1 && nums[i]!=candidate2){
                count1--;
                count2--;
            }
        }
        
        int bar=nums.length/3, counter1=0, counter2=0;
        for(int num:nums){
            if(num==candidate1)
                counter1++;
            else if(num==candidate2)
                counter2++;
        }
        
        List<Integer> result = new ArrayList<>();
        if(counter1>bar)
            result.add(candidate1);
        if(counter2>bar)    
            result.add(candidate2);
        return result;
    }
}
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, result, list, 0);
        return result;
    }
    
    private void subsetsWithDupHelper(int[] nums, List<List<Integer>> result, List<Integer> list, int index){
        result.add(new ArrayList<>(list));
        
        for(int i=index; i<nums.length; i++){
            if(i!=index && nums[i]==nums[i-1])
                continue;
                
            list.add(nums[i]);
            subsetsWithDupHelper(nums, result, list, i+1);
            list.remove(list.size()-1);
        }
    }
}
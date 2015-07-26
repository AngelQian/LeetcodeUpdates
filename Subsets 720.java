public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(nums, result, list, 0);
        return result;
    }
    
    private void subsetsHelper(int[] nums, List<List<Integer>> result, List<Integer> list, int cur){
        result.add(new ArrayList<>(list));
        for(int i=cur; i<nums.length; i++){
            list.add(nums[i]);
            subsetsHelper(nums, result, list, i+1);
            list.remove(list.size()-1);
        }
    }
}
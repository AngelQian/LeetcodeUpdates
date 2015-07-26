public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        permuteHelper(nums, result, path);
        return result;
    }
    
    private void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> path){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!path.contains(nums[i])){
                path.add(nums[i]);
                permuteHelper(nums, result, path);
                path.remove(path.size()-1);
            }
        }
    }
}
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteUniqueHelper(nums, result, path, visited);
        return result;
    }
    private void permuteUniqueHelper(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] visited){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=0; i<visited.length; i++){
            if(visited[i] == true)
                continue;
             if(i>0 && nums[i]==nums[i-1] && visited[i-1]==true)
                 return;
                
            visited[i]=true;
            path.add(nums[i]);
            permuteUniqueHelper(nums, result, path, visited);
            
            path.remove(path.size()-1);
            visited[i]=false;
        }
    }
}
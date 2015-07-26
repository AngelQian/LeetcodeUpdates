public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSumHelper(candidates, target, result, path, 0);
        return result;
    }
    
    private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int index){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=index; i<candidates.length; i++){
            int num = candidates[i];
            if(target < num)
                return;
            path.add(num);
            combinationSumHelper(candidates, target-num, result, path, i);
            path.remove(path.size()-1);
        }
    }
}
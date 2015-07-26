public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSum2Helper(candidates, target, result, path, 0);
        return result;
    }
    
    private void combinationSum2Helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int index){
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        int prev = -1;
        for(int i=index; i<candidates.length; i++){
            int num = candidates[i];
            if(target<num)
                return;
            if(prev==num)
                continue;
                
            path.add(num);
            prev = num;
            combinationSum2Helper(candidates, target-num, result, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
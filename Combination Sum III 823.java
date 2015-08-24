public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //[[1,2,4]]
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(k,n,1,path,result);
        return result;
    }
    
    private void dfs(int k, int sum, int start, List<Integer> list, List<List<Integer>> result){
        if(sum==0 && list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        if(list.size()>k)
            return;
        if(start>sum)
            return;
        
        for(int i=start; i<=9; i++){
            list.add(i);
            dfs(k, sum-i, i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}
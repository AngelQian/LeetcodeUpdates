public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>  list = new ArrayList<>();
        combineHelper(1,n,k,result,list);
        return result;
    }
    
    private void combineHelper(int start, int end, int k, List<List<Integer>> result, List<Integer>  list){
        if(k==0){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=start; i<=end; i++){
            list.add(i);
            combineHelper(i+1, end, k-1, result, list);
            list.remove(list.size()-1);
        }
    }
}
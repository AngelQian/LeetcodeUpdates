public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> li = new ArrayList<>();
            for(int j=0; j<=i; j++){
				if (j == 0) {
					li.add(1);
				} else{
					List<Integer> helper = result.get(i-1);
					int add = j>=helper.size() ? 0 : helper.get(j);
					li.add(helper.get(j-1)+add);
				}
            }
            result.add(li);
        }
        return result;
    }
}
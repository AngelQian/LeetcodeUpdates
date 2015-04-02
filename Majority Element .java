public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> hm = new HashMap<>();
		int result_count = 0, result = 0;
		for(int i=0; i<num.length; i++){
			if(!hm.containsKey(num[i]))
				hm.put(num[i], 1);
			else
				hm.put(num[i], hm.get(num[i])+1);
			
			if(result_count < hm.get(num[i])){
				result_count = hm.get(num[i]);
				result = num[i];
			}
		}
		return result;
    }
}
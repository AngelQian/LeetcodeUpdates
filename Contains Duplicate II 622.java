public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int v = nums[i];
            if(!hm.containsKey(v)){
                hm.put(v,i);
            }else{
                int p = hm.get(v);
                if(i-p<=k)
                    return true;
                else
                    hm.put(v,i);
            }
        }
        return false;
    }
}
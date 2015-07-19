public class Solution {
    public int majorityElement(int[] nums) {
        int mid = nums.length/2;
        int k = nums[0];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            k = nums[i];
            if(!hm.containsKey(k)){
                hm.put(k,1);
            }else{
                hm.put(k, hm.get(k)+1);
                if(hm.get(k) > mid)
                    return k;
            }
        }
        return k;
    }
}
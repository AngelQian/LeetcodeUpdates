public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int len = 1<<n;
        for(int i=0; i<len; i++){
            list.add(i^(i>>1));
        }
        return list;
    }
    
}
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String prot = String.valueOf(arr);
            if(!map.containsKey(prot)){
            	map.put(prot, new ArrayList<>());
            }
            map.get(prot).add(str);
        }
        
        for(List<String> list:map.values())
            result.add(list);
            
        return result;
    }
}
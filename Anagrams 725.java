public class Solution {
    public List<String> anagrams(String[] strs) {
        //每一个单词按照字母顺序排序后都变成同一个单词，那么就是anagram
        //回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。
        //eat, eta, aet, ate
            
        HashMap<String,ArrayList<String>> hs = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(hs.containsKey(s)){
                hs.get(s).add(strs[i]);    
            }else{
            	ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                hs.put(s,list);
            }
        }

        List<String> result = new ArrayList<>();
        for(ArrayList<String> list : hs.values()){
            if(list.size()>1){
                result.addAll(list);
            }
        }
        
        return result;
    }
}
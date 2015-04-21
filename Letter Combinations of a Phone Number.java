public class Solution {
    private String[] keyboard = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		String path = "";
		dfs_lc(digits,0,path,result);
		return result;
	}
	private void dfs_lc(String digits, int index, String path, List<String> result){
		if(index == digits.length()){
		    if(path.length()>0)
	    		result.add(path);
			return;
		}
		
		String s = keyboard[digits.charAt(index)-'0'];
		for(int i=0; i<s.length(); i++){
			dfs_lc(digits, index+1, path+s.charAt(i), result);
		}
		
	}
}
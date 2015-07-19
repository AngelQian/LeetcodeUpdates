public class Solution {
    private String[] plate = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		letterCombinationsHelper(digits, result, 0, "");
		return result;
	}

	private void letterCombinationsHelper(String digits, List<String> result, int index, String path) {
	    if(digits.length()<1)
	        return;
	        
		if (index == digits.length()) {
			result.add(path);
			return;
		}
		
		String s = plate[digits.charAt(index) - '0'];
		for (int j = 0; j < s.length(); j++)
			letterCombinationsHelper(digits, result, index + 1,	path + s.charAt(j));
	}
}
public class Solution {
    public String reverseWords(String s) {
        String[] sarr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = sarr.length - 1; i >= 0; i--) {
			if (sarr[i].trim().length() > 0)
				sb.append(sarr[i] + " ");
		}
		return sb.toString().trim();
    }
}
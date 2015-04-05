public class Solution {
    public String countAndSay(int n) {
        String result = "1";

		for (int i = 1; i < n; i++) {
			String initial = result;
			String value = "";
			for (int j = 0, k = 1; j < initial.length(); j++) {
				k=1;
				while (j+1 < initial.length() && initial.charAt(j+1) == initial.charAt(j)) {
					k++;
					j++;
				}
				value += "" + k + initial.charAt(j);
			}
			result = value;
		}
		return result;
    }
}
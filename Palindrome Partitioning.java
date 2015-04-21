public class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
		boolean[][] log = new boolean[len][len];
		HashMap<Integer, List<List<String>>> results = new HashMap<>();

		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if ((s.charAt(i) == s.charAt(j)) && (j - i < 2 || log[i + 1][j - 1] == true))
					log[i][j] = true;

				if (log[i][j]) {
					String parlindrome = s.substring(i, j + 1);
					if (j == len - 1) {
						ArrayList<String> as = new ArrayList<String>();
						as.add(parlindrome);
						if (!results.containsKey(i)){
							List<List<String>> lls = new ArrayList<>();
							lls.add(as);
							results.put(i, lls);
						}
						else
							results.get(i).add(as);
					} else {
						for (List<String> as_list : results.get(j + 1)) {
							List<String> ls = new ArrayList<>(as_list);
							ls.add(0, parlindrome);
							if (!results.containsKey(i)) {
								List<List<String>> lls_list = new ArrayList<>();
								lls_list.add(ls);
								results.put(i, lls_list);
							} else
								results.get(i).add(ls);
						}
					}
				}

			}
		}

		return results.get(0);
    }
}
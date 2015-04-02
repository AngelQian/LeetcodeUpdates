public class Solution {
    public int compareVersion(String version1, String version2) {
		String[] sv1 = version1.trim().split("\\.");
		String[] sv2 = version2.trim().split("\\.");
		int l = Math.max(sv1.length , sv2.length);
		for (int i = 0; i < l; i++) {
			int s1 = i<sv1.length ? Integer.parseInt(sv1[i]) : 0;
			int s2 = i<sv2.length ? Integer.parseInt(sv2[i]) : 0;
			if (s1 != s2)
				return s1 > s2 ? 1 : -1;
		}
		
		return 0;
	}

}
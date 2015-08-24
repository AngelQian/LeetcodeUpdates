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
==================================================================
public class Solution {
    public int compareVersion(String version1, String version2) {
        //正则表达式split("\\.")
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i=0, j=0; i<v1.length || j<v2.length; i++, j++){
            int n1=i<v1.length? Integer.parseInt(v1[i]):0;
            int n2=j<v2.length? Integer.parseInt(v2[j]):0;
            if(n1 != n2)
                return n1>n2? 1:-1;
        }
        return 0;
    }
}

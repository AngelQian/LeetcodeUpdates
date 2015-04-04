public class Solution {
    public String convert(String s, int nRows) {
        StringBuilder[] sbarr = new StringBuilder[nRows];
		for (int i = 0; i < nRows; i++)
			sbarr[i] = new StringBuilder();

		for (int i = 0; i < s.length();) {
			for (int j = 0; j < nRows && i < s.length(); j++)
				sbarr[j].append(s.charAt(i++));
			for (int j = nRows-2; j >=1 && i < s.length(); j--)
				sbarr[j].append(s.charAt(i++));
		}

		for (int i = 1; i < nRows; i++)
			sbarr[0].append(sbarr[i]);
		return sbarr[0].toString();
    }
}
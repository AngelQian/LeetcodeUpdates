public class Solution {
    public int lengthOfLastWord(String s) {
        StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		s = sb.toString().trim(); 
		int i = 0;
		for (; i < s.length(); i++) {
			if (!Character.isLetter(s.charAt(i)))
				break;
		}

		return i;
    }
}
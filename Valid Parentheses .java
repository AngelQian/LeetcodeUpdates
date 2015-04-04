public class Solution {
    public boolean isValid(String s) {
		Stack<Character> sc1 = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[')
				sc1.push(c);
			else if (sc1.isEmpty())
					return false;
			else if (c == ')') {
				if (sc1.peek() != '(')
					return false;
				else
				    sc1.pop();
			} else if (c == '}') {
				if (sc1.peek() != '{')
					return false;
				else
				    sc1.pop();
			} else if (c == ']') {
				if (sc1.peek() != '[')
					return false;
				else
				    sc1.pop();
			} else
				return false;
		}
		return sc1.isEmpty();
    }
}
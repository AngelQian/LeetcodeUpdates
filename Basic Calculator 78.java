public class Solution {
    public int calculate(String s) {
        s = s.trim();
		Stack<Integer> sc = new Stack<>();
		int result = 0;
		int number = 0;
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isSpaceChar(c))
				continue;
			else if (c == '+') {
				result += sign * number;
				number = 0;
				sign = 1;
			} else if (c == '-') {
				result += sign * number;
				number = 0;
				sign = -1;
			} else if (c == '(') {
				sc.push(result);
				sc.push(sign);
				sign = 1;
				result = 0;
			} else if (c == ')') {
				result += sign * number;
				number = 0;
				result = result * sc.pop()+sc.pop();
			} else if (Character.isDigit(c)) {
				number = 10 * number + (c - '0');
			}
		}
		if (number != 0)
			result += sign * number;
		return result;
    }
}
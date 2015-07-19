public class Solution {
    public boolean isHappy(int n) {
        int n1 = n, sum = 0;
		HashSet<Integer> hs = new HashSet<>();
		while (!hs.contains(n1)) {
			hs.add(n1);
			sum=0;
			while (n1 > 0) {
				int x=n1%10;
				sum += x*x;
				n1 /= 10;
			}
			n1=sum;
		}
		return sum==1;
    }
}
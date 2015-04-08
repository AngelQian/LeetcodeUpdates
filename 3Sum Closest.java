public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = 0;
		int gap = Integer.MAX_VALUE;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			for (int j = i + 1, k = num.length - 1; j < k;) {
				int sum = num[i] + num[j] + num[k];
				if (Math.abs(sum - target) < gap) {
					result = sum;
					gap = Math.abs(sum - target);
					if (gap == 0)
						return result;
				//	j++; // k--;
				}
				if (sum > target)
					k--;
				else
					j++;
			}
		}
		return result;
    }
}
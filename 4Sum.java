public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
       List<List<Integer>> result = new ArrayList<>();
		if (num.length < 4)
			return result;

		Arrays.sort(num);
		for (int i1 = 0; i1 < num.length-3; i1++) {
			if (i1>0 && num[i1] == num[i1-1])
				continue;
			
			for (int i4 = num.length - 1; i4 > i1 + 2; i4--) {
				if (i4<num.length-1 && num[i4] == num[i4+1])
					continue;
				
				int need = target - num[i1] - num[i4];
				int i2 = i1 + 1, i3 = i4 - 1;
				while (i2 < i3) {
					if (i2>i1+1 && num[i2] == num[i2-1]){
						i2++;
						continue;
					}
					if (i3<i4-1 && num[i3] == num[i3+1]){
						i3--;
						continue;
					}

					if (need > num[i2] + num[i3]) {
						i2++;
					} else if (need < num[i2] + num[i3]) {
						i3--;
					} else {
						result.add(Arrays.asList(num[i1], num[i2], num[i3],
								num[i4]));
						i2++;
						i3--;
					}
				}
			}
		}
		return result;
        
    }
}
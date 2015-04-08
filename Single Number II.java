public class Solution {
    public int singleNumber(int[] A) {
        if (A.length < 1)
			return 0;

		int value = A[0];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (!hm.containsKey(A[i]))
				hm.put(A[i], 1);
			else if (hm.get(A[i]) < 3){
				hm.put(A[i], hm.get(A[i]) + 1);
				if(hm.get(A[i]) == 3)
					hm.remove(A[i]);
			}
		}

		for (int h : hm.keySet())
			value = h;
		return value;
    }
}
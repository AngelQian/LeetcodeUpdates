public class Solution {
    public String largestNumber(int[] nums) {
        String[] num = new String[nums.length];
		for(int i=0; i<nums.length; i++)
			num[i] = ""+nums[i];
		
		Comparator<String> comp = new Comparator<String>() {
			public int compare(String o1, String o2) {
				String s1 = o1.concat(o2);
				String s2 = o2.concat(o1);
				return s2.compareTo(s1);
			}
		};
		Arrays.sort(num,comp);
		if(Integer.parseInt(num[0])==0)
		    return ""+0;
		    
		StringBuilder sb = new StringBuilder();
		for(String s:num)
			sb.append(s);
		return sb.toString();
    }
}
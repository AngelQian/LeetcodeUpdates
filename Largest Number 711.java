public class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> str_nums = new ArrayList<>();
		for(int x:nums)
			str_nums.add(""+x);
		Collections.sort(str_nums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String s:str_nums)
			sb.append(s);
		
		if(sb.length()<1 || sb.charAt(0)=='0')
			return "0";
			
        return sb.toString();
    }
}
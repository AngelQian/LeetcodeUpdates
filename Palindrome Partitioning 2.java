public class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> result = new ArrayList<>();
		List<String> path = new ArrayList<>();
		partitionDFS(s,result,0,path);
		return result;
	}
	private void partitionDFS(String s, List<List<String>> result, int start, List<String> path){
		if(start == s.length()){
			result.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=start; i<s.length(); i++){
			String sub = s.substring(start,i+1);
			if(validPalindrom(sub)){
				path.add(sub);
				partitionDFS(s,result,i+1,path);
				path.remove(path.size()-1);
			}
		} 
	}
	private boolean validPalindrom(String s){
		for(int i=0,j=s.length()-1; i<j; i++,j--)
			if(s.charAt(i) != s.charAt(j))
				return false;
		return true;
	}
}
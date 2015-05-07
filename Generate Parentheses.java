public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(0,0,n,"",result);
        return result;
    }
    private void generateParenthesisHelper(int left, int right, int total, String s, List<String> result){
        if(s.length() == total*2)
        {
            result.add(s.toString());
            return;
        }
        
        if(left<total)
            generateParenthesisHelper(left+1, right, total, s+"(", result);
        if(right<left)
            generateParenthesisHelper(left, right+1, total, s+")", result);
    }
}
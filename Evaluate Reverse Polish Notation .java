public class Solution {
    private Stack<Integer> si = new Stack<>();
    private HashSet<String> hs = new HashSet<>();
    public int evalRPN(String[] tokens) {
    	hs.add("+");
    	hs.add("-");
    	hs.add("*");
    	hs.add("/");
    	
         for (String s : tokens) {
            if(hs.contains(s)){
            	calculate(s);
            }else{
            	si.add(Integer.parseInt(s));
            }
        }
        return si.pop();
    }
    private void calculate(String append){
    	int a2=si.pop();
    	int a1=si.pop();
    	if(append.equals("+"))
    		si.push(a1+a2);
    	else if(append.equals("-"))
    		si.push(a1-a2);
    	else if(append.equals("*"))
    		si.push(a1*a2);
    	else if(append.equals("/"))
    		si.push(a1/a2);
    }
}
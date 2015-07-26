public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        LinkedList<String> queue = new LinkedList<>();
        for(String s: path.split("/")){
            if(s.equals("..")){
                if(!queue.isEmpty())
                    queue.removeLast();
            }
            else if(!s.equals(".") && !s.equals(""))
                queue.add(s);
        }
        
        for(String s: queue)
            sb.append(s).append("/");
            
        if(!queue.isEmpty())  
            sb.setLength(sb.length()-1);
            
        return sb.toString();    
    }
}
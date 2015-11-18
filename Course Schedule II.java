public class Solution {
    private int[] result;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        result = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++)
            adjs.add(new ArrayList<>());
        for(int[] edge : prerequisites){
            inDegree[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }   
        
        label = numCourses-1;
        return byDFS(adjs);
        // return byBFS(inDegree, adjs);
    }
    
    private int label;
    private int[] byDFS(List<List<Integer>> adjs){
        int[] visited = new int[adjs.size()];
        for(int i=0; i<adjs.size(); i++){
            if(!DFS(visited, adjs, i))
                return new int[0];
        }
        return result;
    }
    private boolean DFS(int[] visited, List<List<Integer>> adjs, int start){
        if(visited[start]==-1)
            return false;
        if(visited[start]==1)
            return true;
            
        visited[start] = -1;
        for(int end : adjs.get(start)){
            if(!DFS(visited, adjs, end))
                return false;
        }
        result[label --] = start;
        visited[start] = 1;
        return true;
    }
    
    private int[] byBFS(int[] inDegree, List<List<Integer>> adjs){
        Queue<Integer> toVisit = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i]==0)
                toVisit.add(i);
        }
        
        int visited=0;
        while(!toVisit.isEmpty()){
            int start=toVisit.remove();
            result[visited++]=start;
            for(int end: adjs.get(start)){
                inDegree[end]--;
                if(inDegree[end]==0)
                    toVisit.add(end);
            }
        }
        
        return (visited==inDegree.length) ? result : new int[0];
    }
}
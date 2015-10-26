public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //no circle
       int[][] matrix = new int[numCourses][numCourses];
       for(int i=0; i<prerequisites.length; i++)
           matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
       
       int[] isVisited = new int[numCourses];
       for(int node=0; node<numCourses; node++){
           if(isVisited[node]==0){
               if(!DFS(node, isVisited, matrix))
                    return false;
           }
       }
       return true;
    }
    
    private boolean DFS(int course, int[] isVisited, int[][] matrix){
        isVisited[course]=1;
        for(int adj=0; adj<matrix.length; adj++){
            if(matrix[course][adj]==1){
                if(isVisited[adj]==1)
                    return false;
                if(isVisited[adj]==0 && !DFS(adj, isVisited, matrix))
                    return false;
            }
        }
        isVisited[course]=2;
        return true;
    }
}
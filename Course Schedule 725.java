public class Solution {
    static class Course{
        private ArrayList<Course> preList = new ArrayList<>();
        void addPre(Course pre){
            preList.add(pre);
        }
        
        private boolean visited;
        boolean isCircle(){
            if(visited)
                return true;
                
            visited=true;
            for(Course preCourse : preList){
                if(preCourse.isCircle())
                    return true;
            }
            
            visited=false;
            return false;
        }
        
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //none circle
        Course[] clist = new Course[numCourses];
        for(int i=0; i<clist.length; i++)
            clist[i] = new Course();
        
        for(int[] couple: prerequisites){
            Course c1 = clist[couple[0]];
            Course c2 = clist[couple[1]];
            c1.addPre(c2);
        }    
        
        for(int i=0; i<clist.length; i++){
            if(clist[i].isCircle())
                return false;
        }
        
        return true;
    }
}
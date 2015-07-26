public class Solution {
    static class Course{
        public ArrayList<Course> preList = new ArrayList<>();
        void addPre(Course pre){
            preList.add(pre);
        }
        
        public boolean visited;
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
            if(isCircle(clist[i]))
                return false;
        } 
        return true;
    }
    
    private boolean isCircle(Course course){
        if(course.visited == true)
            return true;
        
        course.visited = true;
        for(Course pre: course.preList)
        {
            if(isCircle(pre))
                return true;
        }
        course.visited = false;
        return false;
    }
}
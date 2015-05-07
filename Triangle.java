public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int min = 0;
        if(row<1)
           return min;
           
        int[] f = new int[row];
        f[0] = triangle.get(0).get(0);
        min=f[0];
        
        for(int i=1; i<row; i++)
            f[i] = Integer.MAX_VALUE;
        
        for(int i=1; i<row; i++){
            List<Integer> li = triangle.get(i);
            min = Integer.MAX_VALUE;
            for(int j=li.size()-1; j>=0; j--)
            {
                if(j>0)
                  f[j] = Math.min(f[j],f[j-1])+li.get(j);
                else
                  f[j] = f[j]+li.get(j);
                  
                min = Math.min(f[j],min);
            }
        }
        
        return min;
    }
}
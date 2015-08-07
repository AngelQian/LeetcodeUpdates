public class Solution {
    public int candy(int[] ratings) {
        int[] f = new int[ratings.length];
        for(int i=1, inc=1; i<ratings.length; i++){
            if(ratings[i]>ratings[i-1])
                f[i] = Math.max(inc++, f[i]);
            else
                inc=1;
        }
        
        for(int i=ratings.length-2, inc=1; i>=0; i--){
            if(ratings[i]>ratings[i+1])
                f[i] = Math.max(inc++, f[i]);
            else
                inc=1;
        }
        
        int result = 0;
        for(int i=0; i<f.length; i++){
            result += f[i];
        }
        
        return result+f.length;
    }
}
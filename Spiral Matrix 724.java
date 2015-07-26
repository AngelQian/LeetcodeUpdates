public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        if(row<1)
            return list;
        
        int col = matrix[0].length;
        if(col<1)
            return list;
            
        int top=0, right=col-1, bottom=row-1, left=0;
        while(top<=bottom && left<=right){
                for(int j=top; j<=right; j++)
                    list.add(matrix[top][j]);
                top++;   
                
                for(int i=top; i<=bottom; i++)
                    list.add(matrix[i][right]);
                right--;
             
             if(top<=bottom){   
                for(int j=right; j>=left; j--)
                    list.add(matrix[bottom][j]);
                bottom--;
             }
                
             if(left<=right){
                for(int i=bottom; i>=top; i--)
                    list.add(matrix[i][left]);
                left++;
             }
        }
        return list;
    }
}
public class Solution {
    public int removeElement(int[] A, int elem) {
        int i=0,j=0;
        for(;j<A.length;j++)
        {
            if(A[j]!=elem)
              A[i++]=A[j];
        }
        return i;
    }
}
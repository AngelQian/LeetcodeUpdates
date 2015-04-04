public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i=m+n-1, p=m-1, q=n-1;
        while(i>=0 && p>=0 && q>=0){
            A[i--] = A[p]>B[q] ? A[p--]:B[q--];
        }
        
        while(q>=0)
          A[i--] = B[q--];
    }
}
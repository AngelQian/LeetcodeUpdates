public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if((len&1)==1)
            return find_Kth(nums1, 0, nums1.length, nums2, 0, nums2.length, len/2+1);
        else
            return (find_Kth(nums1, 0, nums1.length, nums2, 0, nums2.length, len/2)
                    +find_Kth(nums1, 0, nums1.length, nums2, 0, nums2.length, len/2+1))/2.0;
    }
    
    private double find_Kth(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k){
        int first=right1-left1, second=right2-left2;
        
        if(first>second)
             return find_Kth(nums2,left2, right2, nums1, left1, right1, k);
        if(first==0)
            return nums2[k-1];
        if(k==1)
            return Math.min(nums1[0], nums2[0]);
        
        int i1=Math.min(k/2, first), i2=k-i1;
        if(nums1[i1-1]<nums2[i2-1]){
            int[] n1=new int[right1-left1-i1];
            for(int i=0; i<n1.length; i++)
                n1[i]=nums1[i+i1];
            return find_Kth(n1, 0, n1.length, nums2, left2, right2, k-i1);
        }
        else if(nums1[i1-1]>nums2[i2-1]){
            int[] n2=new int[right2-left2-i2];
            for(int i=0; i<n2.length; i++)
                n2[i]=nums2[i+i2];
            return find_Kth(nums1, left1, right1, n2, 0, n2.length, k-i2);
        }
        else
            return nums1[i1-1];
    }
}
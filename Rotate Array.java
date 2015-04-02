public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int r = k%n;
        reverseArray(nums,0,n-1);
        reverseArray(nums,0,r-1);
        reverseArray(nums,r,n-1);

	/*	for (int i = 0; i < k%n; i++) {
			int temp = nums[n - 1];
			for (int j = n - 1; j > 0; j--)
				nums[j] = nums[j - 1];
			nums[0] = temp;
		}
	*/	
    }
    public void reverseArray(int[] arr, int start, int end){
        for(int i=start,j=end; i<=(start+end)/2 && i<j; i++,j--){
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
    }
}
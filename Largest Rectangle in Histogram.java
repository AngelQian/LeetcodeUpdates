public class Solution {
    public int largestRectangleArea(int[] height) {
        int[] copy = new int[height.length+1];
        for(int i=0; i<height.length; i++)
            copy[i]=height[i];
        copy[height.length]=0;
        
        int max = 0, k=0;
        Stack<Integer> stack = new Stack<>();
        while(k<copy.length){
            if(stack.isEmpty() || copy[stack.peek()]<=copy[k])
                stack.push(k++);
            else{
                int h=copy[stack.pop()];
                int w=stack.isEmpty() ? k : k-stack.peek()-1;//因为已经Pop出去了一个，peek的是更加小的值
                max=Math.max(max, w*h);
            }    
        }
        
        return max;
    }
}
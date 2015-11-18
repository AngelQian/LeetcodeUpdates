public class Solution {
    public int trap(int[] height) {
        // return byStack(height);
        return byPointers1(height);
    }
    private int byPointers1(int[] height) {
        int len = height.length;
        if(len<3)
            return 0;
            
        int[] left_bar = new int[len];
        int[] right_bar = new int[len];
        left_bar[0]=height[0];
        right_bar[len-1]=height[len-1];
        for(int i=1; i<len; i++){
            left_bar[i] = Math.max(left_bar[i-1], height[i]);
            right_bar[len-i-1] = Math.max(right_bar[len-i],height[len-i-1]);
        }
        
        int vol=0;
        for(int i=0; i<len; i++){
            int h = Math.min(left_bar[i],right_bar[i])-height[i];
            vol+= h>0?h:0;
        }
        
        return vol;
    }
    
/*    思路1：stack解法

能积水的地方必然是一个中间低两边高的凹陷。所以寻找的目标是一个递减序列之后的递增。由于积水量只有在递增时才能计算，而计算又可能需要用到递减序列中的多个bar。因此必须将递减序列cache起来。这里使用stack。为了便于面积计算中宽度的计算，stack存放的不是递减序列bar的高度，而是每个bar的坐标。
*/

        //用一个栈辅助，小于栈顶的元素压入，大于等于栈顶就把栈里所有小于或等于当前值的元素全部出栈处理掉。
        
    private int byStack(int[] height) {
        if(height.length<3)
            return 0;
            
        Stack<Integer> stack = new Stack<>();
        int vol=0;
        for(int i=0; i<height.length; i++){
            if(stack.isEmpty() || height[i]<=height[stack.peek()])//维持递减栈
                stack.push(i);
            else//遇到积水
            {
                int bottom = stack.pop();
                if(!stack.isEmpty())
                    vol+=(i-stack.peek()-1)*(Math.min(height[stack.peek()],height[i])-height[bottom]);
                i--;    
            }
        }
        return vol;
    }
}
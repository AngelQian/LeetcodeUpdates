public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0, len=gas.length ;
        int pre=0,total=0;
        for(int i=0; i<len; i++){
            pre+=gas[i]-cost[i];
            total+=pre;
            if(pre<0){
                start=i+1;
                pre=0;
            }
        }
        return total<0?-1:start;
    }
}
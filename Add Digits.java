public class Solution {
    public int addDigits(int num) {
        if(num<1)
            return 0;
            
        //规律：任意自然数%9=各个位置上的数字最终的和
        int val = num%9;
        if(val!=0)
            return val;
        else{
            return 9;
        }    
    }
}

根据提示，由于结果只有一位数，因此其可能的数字为0 - 9

使用方法I的代码循环输出0 - 19的运行结果：

in  out  in  out
0   0    10  1
1   1    11  2
2   2    12  3
3   3    13  4
4   4    14  5
5   5    15  6
6   6    16  7
7   7    17  8
8   8    18  9
9   9    19  1
public class Solution {
    public String convertToTitle(int n) {
        //思路，每一次通过取模获得最低位的字母；
        //同时需要注意的是：从字母A开始的话，已经算了一个1
        StringBuilder builder = new StringBuilder();
        while(n>0){
            n--;
            int x=n%26;
            builder.append((char)('A'+x));
            n/=26;
        }
        return builder.reverse().toString();
    }
}

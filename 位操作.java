位操作
Power of Two Total Accepted: 20300 Total Submissions: 68014 My Submissions Question Solution 
Given an integer, write a function to determine if it is a power of two.
//count the number of digit 1 
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
            
        int count=0;
        while(n!=0){
            if((n&1)==1)
                count ++;
            if(count>=2)
                return false;
            n >>>= 1;
        }
        return count==1;
    }
}
==============================
Bitwise AND of Numbers Range Total Accepted: 16442 Total Submissions: 64715 My Submissions Question Solution 
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
-------------------
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int step=0;
        while(m!=n){
            m>>=1;
            n>>=1;
            step++;
        }
        return m<<step;
    }
}
=================================
Number of 1 Bits Total Accepted: 44366 Total Submissions: 116882 My Submissions Question Solution 
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
-------------
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count += ((n&1)==1?1:0);
            n>>>=1;
        }
        return count;
    }
}
===============================
Reverse Bits Total Accepted: 32799 Total Submissions: 113942 My Submissions Question Solution 
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
---------------
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0;
        for(int i=0; i<32; i++){
            int x=n&1;
            result = result*2+x;
            n>>>=1;
        }
        return result;
    }
}
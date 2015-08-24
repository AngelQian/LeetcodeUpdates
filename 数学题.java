数学题
Majority Element II Total Accepted: 8860 Total Submissions: 40095 My Submissions Question Solution 
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space
-------------
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length<1)
            return result;
        
        int candidate1=-1, candidate2=-1, count1=0,count2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==candidate1)
                count1++;
            else if(nums[i]==candidate2)
                count2++; 
            else if(count1==0){
                candidate1=nums[i];
                count1++;
            }else if(count2==0){
                candidate2=nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }    
        }
        
        count1=count2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==candidate1)
                count1++;
            else if(nums[i]==candidate2)
                count2++;   
        }
        
        if(count1> nums.length/3)
            result.add(candidate1);
        if(count2> nums.length/3)
            result.add(candidate2);
            
        return result;
    }
}
=============
Count Primes Total Accepted: 27602 Total Submissions: 138447 My Submissions Question Solution 
Description:

Count the number of prime numbers less than a non-negative number, n.
------------------
public class Solution {
    public int countPrimes(int n) {
        int result=0;
        boolean[] helper = new boolean[n];
        for(int i=2; i<n; i++){
            if(helper[i]==false){
                result++;
                for(int j=i*2; j<n; j+=i)
                     helper[j]=true;
            }
        }
        return result;
    }
}
=============
Happy Number Total Accepted: 26597 Total Submissions: 83426 My Submissions Question Solution 
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
--------------
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs= new HashSet<>();
        int r=n;
        
        while(!hs.contains(r)){
            hs.add(r);
            r = next(r);
        }
        
        return r==1;
    }
    
    private int next(int n){
        int number=0;    
        while(n!=0){
            int x=n%10;
            number += x*x;
            n/=10;
        }
        return number;
    }
}
====================================
Factorial Trailing Zeroes Total Accepted: 33139 Total Submissions: 113383 My Submissions Question Solution 
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
--------------------------------
public class Solution {
    public int trailingZeroes(int n) {
        //计算有多少个5
        int count=0;
        while(n/5>=1){
            n /= 5;
            count += n;
        }
        return count;
    }
}
=========================================

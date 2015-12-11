//...12.10
Pow(x, n)
public class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            long exp=-n;
            return 1/helper(x,exp);
        }else
            return helper(x,n);
    }
    
    private double helper(double x, long n){
        if(n==0)
            return 1;
        if(n==1)
            return x;
        
        if(n%2==1)  
            return helper(x, n-1)*x;
        else{
            double tmp = helper(x, n/2);    
            return tmp*tmp; 
        }
    }
}
===========================================================

public class Solution {
    public double myPow(double x, int n) {
        // X^n = X^(n/2)*X^(n/2)*X^(n%/2)
        
        if(n<0)
        {
            n=-n;
            x=1/x;
        }
        if(n==0)
            return 1;
            
        double number = myPow(x, n/2); 
        if(n%2==0)
            return number*number;
        else
            return x*number*number;
            
    }
}

//写法二
public class Solution {
    public double myPow(double x, int n) {
        // X^n = X^(n/2)*X^(n/2)*X^(n%/2)
        if(n<0)
            return 1/myPowHelper(x,-n);
        else
            return myPowHelper(x,n);
    }
    
    private double myPowHelper(double x, int n){
        if(n==0)
            return 1;
            
        double number = myPow(x, n/2); 
        if(n%2==0)
            return number*number;
        else
            return x*number*number;
    }
}

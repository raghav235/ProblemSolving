package com.learning.miscellaneous;

public class NumberOfPossibleStringAfterDecoding {
    public static void main(String[] args) {
        String s="123";// o/p=3 [abc, aw, lc]    a-1, b-2, c-3,.... z-26
        System.out.println(getTotalPossibleString(s));
    }

    public static int getTotalPossibleString(String num){
        return helper(num,num.length());
    }

    public static int helper(String num, int k){
        if(k==0){
            return 1;
        }
        else if(num.charAt(num.length()-k)=='0'){
            return 0;
        }
        else{
            int startIndex=num.length()-k;
            int result= helper(num,k-1);
            if(k>=2 && Integer.parseInt(""+num.substring(startIndex,startIndex+2))<=26){
                result=result+helper(num,k-2);
            }
        return result;
        }

    }
}
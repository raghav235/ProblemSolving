package com.learning.miscellaneous;

public class StringToInteger {

    public static void main(String[] args) {
        String s="123";
        int n = getAsInteger(s);
        System.out.println(n);
    }

    private static int getAsInteger(String s) {
        int result=0;
        char[] digits= s.toCharArray();
        for (char ch : digits){
            result = result*10 + ((int)ch-(int)'0');
        }
        return result;
    }

}

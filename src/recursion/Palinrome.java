package recursion;

import java.util.Scanner;

public class Palinrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any input");
        String input = sc.next();
        System.out.println(isPalindrome(input,0,input.length()-1));
    }

    public static boolean isPalindrome(String input, int start, int end){
        if(start >= end){
            return true;
        }

        boolean b = input.charAt(start) == input.charAt(end);
        if (!b){
            return false;
        }

        return isPalindrome(input, start + 1, end - 1);
    }
}

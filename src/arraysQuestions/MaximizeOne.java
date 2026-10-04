package arraysQuestions;

import java.util.Arrays;

public class MaximizeOne {
    public static void main(String[] args) {
        String input = "101";
        System.out.println(Arrays.toString(flip(input)));
    }

    public static int[] flip(String A){
        int[] ans = new int[2];

        int currentZeros = 0;
        int currentR = 0;
        int max = 0;

        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '0'){
                currentR = i;
                currentZeros++;
            } else {
                currentZeros = 0;
            }

            if(currentZeros>0){
                max = Math.max(max, currentZeros);
                ans[0] = i - currentZeros + 1;
                ans[1] = currentR;
            }


        }

        return ans;
    }
}

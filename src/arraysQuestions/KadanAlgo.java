package arraysQuestions;

import java.util.Arrays;

public class KadanAlgo {
    public static void main(String[] args) {
        String input = "1101010001";
        System.out.println(Arrays.toString(findMaxSubArray(input)));
    }

    public static int[] findMaxSubArray(String input){
        int[] ans = new int[2];
        int start = 0;
        int bestStart = 0;
        int bestEnd = 0;

        int firstNumber = input.charAt(0);
        if(firstNumber=='0'){
            firstNumber = 1;
        } else {
            firstNumber = -1;
        }

        int maxSofar = firstNumber;
        int maxEndingHere = firstNumber;

        for(int i = 1; i < input.length(); i++){
            int current = 0;
            if(input.charAt(i)=='0'){
                current = 1;
            } else {
                current = -1;
            }

            if (maxEndingHere + current < current){
                start = i;
                maxEndingHere = current;
            } else {
                maxEndingHere += current;
            }

            if (maxEndingHere > maxSofar){
                bestStart = start;
                bestEnd = i;
            }

            maxSofar = Math.max(maxSofar, maxEndingHere);

        }

        if(maxSofar < 1){
            int[] a = new int[0];
            return a;
        }

        ans[0] = bestStart + 1;
        ans[1] = bestEnd + 1;

        return ans;
    }
}

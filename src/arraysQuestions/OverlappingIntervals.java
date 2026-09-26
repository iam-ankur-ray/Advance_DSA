package arraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;


public class OverlappingIntervals {
    public static void main(String[] args) {
       int[][] intervals = { {1, 4}, {2, 6}, {8, 10},{13,18} };
        printTwoDArray(intervals);
        int[][] overlapInterval = getOverlappingArray(intervals);
        System.out.println("-".repeat(25));
        printTwoDArray(overlapInterval);
    }

    private static void printTwoDArray(int[][] intervals) {
        for(int i = 0; i < intervals.length; i++){
            for(int values: intervals[i]){
                System.out.print(values + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getOverlappingArray(int[][] A){
        int size = A.length;
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> currentInterval = new ArrayList<>();
        currentInterval.add(A[0][0]);
        currentInterval.add(A[0][1]);
        answer.add(currentInterval);

        for(int i = 1; i < size; i++){

            int start = A[i][0];
            int end = A[i][1];
            int currentEnd = currentInterval.get(1);
            int currentStart = currentInterval.getFirst();

            if(currentEnd >= start){
                currentInterval.set(0, Math.min(start, currentStart));
                currentInterval.set(1, Math.max(end,currentEnd));
            } else {
                ArrayList<Integer> newCurrent = new ArrayList<>();
                currentInterval = newCurrent;
                currentInterval.add(0,start);
                currentInterval.add(1,end);
                answer.add(currentInterval);
            }

        }

        int ans_size = answer.size();
        int[][] finalAnswer = new int[ans_size][2];

        for(int i = 0; i < ans_size; i++){
            finalAnswer[i][0] = answer.get(i).getFirst();
            finalAnswer[i][1] = answer.get(i).get(1);
        }

        return finalAnswer;
    }
}

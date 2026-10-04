package arraysQuestions;

import java.util.ArrayList;
import java.util.List;

public class NextInterval {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> add = new ArrayList<>();
        add.add(1);
        add.add(2);
        A.add(add);
        add.add(3);
        add.add(6);
        A.add(add);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(8);
        B.add(10);


        ArrayList<ArrayList<Integer>> finalAnswer = getNextInterval(A,B);

        printTwoDArray(finalAnswer);

    }

    private static void printTwoDArray(ArrayList<ArrayList<Integer>> intervals) {
        for(int i = 0; i < intervals.size(); i++){
            for(int values: intervals.get(i)){
                System.out.print(values + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> getNextInterval(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B){
        int toBeAddedStart = B.get(0);
        int toBeAddedEnd = B.get(1);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> currentInterval = new ArrayList<>();

        currentInterval.add(A.getFirst().getFirst());
        currentInterval.add(A.getFirst().get(1));
        ans.add(currentInterval);

        for(int i = 1; i < A.size(); i++){
            int start = A.get(i).getFirst();
            int end = A.get(i).get(1);

            // check with current interval and to be added in three loops
            if(end > toBeAddedStart){

            }

        }

        return  ans;
    }
}

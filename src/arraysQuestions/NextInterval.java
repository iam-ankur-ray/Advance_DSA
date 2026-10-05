package arraysQuestions;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class NextInterval {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> add = new ArrayList<>();
        ArrayList<Integer> add1 = new ArrayList<>();
        add.add(1);
        add.add(2);
        add1.add(3);
        add1.add(6);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(8);
        B.add(10);
        A.add(add);
        A.add(add1);
        ArrayList<Integer> add3 = new ArrayList<>();
        add3.add(2);
        add3.add(7);

        ArrayList<ArrayList<Integer>> C = insert(A,B);


        System.out.println(C);

    }

    private static void printTwoDArray(ArrayList<ArrayList<Integer>> intervals) {
        for(int i = 0; i < intervals.size(); i++){
            for(int values: intervals.get(i)){
                System.out.print(values + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B) {
        int toBeAddedStart = B.get(0);

        printTwoDArray(A);
        int index = 0;
        for(int i = 0; i < A.size(); i++){
            if(A.get(i).get(1) < toBeAddedStart){
                index++;
            }
        }
        System.out.println("_".repeat(25));
        A.add(index,B);
        printTwoDArray(A);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> currentInterval = new ArrayList<>();
        currentInterval.add(A.get(0).get(0));
        currentInterval.add(A.get(0).get(1));
        ans.add(currentInterval);

        for(int i = 1; i < A.size(); i++){

            int start = A.get(i).get(0);
            int end = A.get(i).get(1);
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
                ans.add(currentInterval);
            }

        }



        return  ans;
    }
}

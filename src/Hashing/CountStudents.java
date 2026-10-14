package Hashing;

import java.util.HashMap;

public class CountStudents {
    public static void main(String[] args) {
        int[] studArray = {2, 5, 9, 2, 8};
        int[] queries = {3, 2};
        HashMap<Integer, Integer> students = new HashMap<>();

        int[] ans = new int[queries.length];

        for(int i = 0; i < studArray.length; i++){
            students.put(studArray[i], students.getOrDefault(studArray[i],0) + 1);
        }
        //Current student list
        System.out.println(students);

        for(int i = 0; i < queries.length; i++){
            if(students.containsKey(queries[i])){
                ans[i] = students.get(queries[i]);
            }
        }

        for(int v: ans){
            System.out.print(v + " ");
        }
    }


}

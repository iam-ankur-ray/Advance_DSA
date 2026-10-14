package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 10, 10, 10};
        int[] arr2 = {3, 6, 2, 10, 10};
        int[] arr = getCommonElements(arr1, arr2);
//        for(int v : arr){
//            System.out.print(v + " ");
//        }
    }

    private static int[] getCommonElements(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int v: arr2){
            hm.put(v, hm.getOrDefault(v,0)+1);
        }

        System.out.println("Array one in Hashmap Frequency");
        System.out.println(hm);

        ArrayList<Integer> arr = new ArrayList<>();

        for(int v : arr1){
            if(hm.containsKey(v) && hm.get(v) > 0){
                arr.add(v);
                hm.put(v, hm.get(v)-1);
            }
        }

        int[] ans = new int[arr.size()];
        int i = 0;
        for(int v : arr){
            ans[i] = v;
            i++;
        }

        System.out.println("For loop in Hashmap");
        for(int v : hm.values()){

            System.out.print(v + " ");


        }

        return ans;
    }
}

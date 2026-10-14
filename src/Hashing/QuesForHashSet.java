package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class QuesForHashSet {
    public static void main(String[] args) {
        int[] arr = {1,3,3,4,5,7,8,9,-2,11};
        //System.out.println(isPairPresent(arr,15));
        int x = countPairs(arr, 5);
        System.out.println(x);
    }

    public static boolean isPairPresent(int[] A, int k){
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            if(hs.contains(k-A[i])){
                return true;
            } else {
                hs.add(A[i]);
            }
        }

        return false;
    }

    public static int countPairs(int[] A, int B){
        final int MODE = 1000000007;
        HashMap<Integer, Integer> hm = new HashMap<>();

        long count = 0;

        for(int i = 0; i < A.length; i++){
            if(hm.containsKey(B - A[i])){
                count += hm.get(B - A[i]);
            }

            if(hm.containsKey(A[i])){
                hm.put(A[i], hm.get(A[i]) + 1);
            } else {
                hm.put(A[i], 1);
            }
        }

        return (int) count % MODE;
    }
}

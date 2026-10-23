package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public  class CheckComparator {
    public int[] Tens(int[] A) {
        Integer[] B = new Integer[A.length];
        int in = 0;
        for (int i : A) {
            B[in] = i;
            in++;
        }
        Arrays.sort(B, (a, b) -> {
                    int tensA = (a / 10) % 10;
                    int tensB = (b / 10) % 10;

                    if (tensA != tensB) {
                        return tensA - tensB;
                    }

                    return b - a;
                }
        );

        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }

        return A;
    }

    public static ArrayList<ArrayList<Integer>> eculideanDistance(ArrayList<ArrayList<Integer>> A, int B){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Collections.sort(A, (a, b) -> {
            long d1 = (long) a.get(0) * a.get(0) + (long) a.get(1) * a.get(1);
            long d2 = (long)b.get(0) * b.get(0) + (long) b.get(1) * b.get(1);
            if(d2 > d1){
                return - 1;
            } else if(d2 < d1){
                return 1;
            } else {
                return 0;
            }
        });

        for(int i = 0; i < B; i++){
            ans.add(A.get(i));
        }
        return ans;
    }

}


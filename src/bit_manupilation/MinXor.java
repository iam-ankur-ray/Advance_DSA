package bit_manupilation;

import java.util.Arrays;

public class MinXor {
    public static void main(String[] args) {
        int[] arr = {0, 2, 5, 7};
        System.out.println(getMinXor(arr));
    }

    public static int getMinXor(int[] A){
        Arrays.sort(A);
        int ans = A[A.length-1];
        System.out.println(Arrays.toString(A));
        for(int i = 1; i < A.length; i++){
            int current = A[i]^A[i-1];
            ans = Math.min(current, ans);
        }

        return ans;
    }
}




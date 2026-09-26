package arraysQuestions;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(getNextPermutation(arr)));
    }

    public static int[] getNextPermutation(int[] A){
        int size = A.length;

        int i = size - 2;
        while (i >= 0 && A[i] > A[i + 1]){
            i--;
        }

        if(i >= 0){
            int j = size - 1;
            while(A[j] <= A[i]){
                j--;
            }

            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        int m = i + 1, n = size - 1;
        while(m < n){
            int temp = A[m];
            A[m] = A[n];
            A[n] = temp;
            m++;
            n--;
        }

        return A;
    }
}

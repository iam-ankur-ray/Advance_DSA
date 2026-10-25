package arraysQuestions;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(getNextPermutation(arr)));
    }

    /**
     *
     * @param A
     * @return
     */
    /**
     * Computes the next lexicographically greater permutation of the given integer array.
     *
     * <p><b>Problem Statement:</b></p>
     * Given an array representing a permutation of numbers, find the next permutation
     * in lexicographical (dictionary) order. If no greater permutation exists
     * (i.e., the array is in descending order), the method rearranges the elements
     * into the smallest possible permutation (ascending order).
     *
     * <p>Examples:</p>
     * <pre>
     * Input : [1, 2, 3]
     * Output: [1, 3, 2]
     *
     * Input : [1, 3, 2]
     * Output: [2, 1, 3]
     *
     * Input : [3, 2, 1]
     * Output: [1, 2, 3]
     * </pre>
     *
     * <p><b>Approach:</b></p>
     * <ol>
     *   <li>Traverse from right to left to find the first index {@code i} such that
     *       {@code A[i] < A[i + 1]}. This element is called the pivot.</li>
     *   <li>If a pivot exists, find the smallest element greater than
     *       {@code A[i]} on its right side and swap them.</li>
     *   <li>Reverse the suffix starting from {@code i + 1} to the end of the array.
     *       Since the suffix was originally in descending order, reversing it
     *       produces the smallest possible arrangement after the pivot.</li>
     * </ol>
     *
     * <p>This guarantees that the resulting array is the immediate next
     * lexicographical permutation.</p>
     *
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(1), as the transformation is performed in place.</p>
     *
     * @param A the input permutation array
     * @return the same array modified in-place to represent the next permutation
     */
    public static int[] getNextPermutation(int[] A) {
        int size = A.length;

        int i = size - 2;
        while (i >= 0 && A[i] > A[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = size - 1;
            while (A[j] <= A[i]) {
                j--;
            }

            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        int m = i + 1, n = size - 1;
        while (m < n) {
            int temp = A[m];
            A[m] = A[n];
            A[n] = temp;
            m++;
            n--;
        }

        return A;
    }
}

package sorting;

public class InversionCount {
    public static void main(String[] args) {
        int[] A = {1,4,5,3,9,5};
        System.out.println(countOfInversion(A));
    }
    private static int countOfInversion(int[] A) {
        final int MOD = 1_000_000_007;
        return (int)(mergeSortAndCount(A, 0, A.length - 1) % MOD);
    }

    private static long mergeSortAndCount(int[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left half
            count += mergeSortAndCount(arr, left, mid);
            count %= 1_000_000_007;

            // Count inversions in right half
            count += mergeSortAndCount(arr, mid + 1, right);
            count %= 1_000_000_007;

            // Count split inversions
            count += mergeAndCount(arr, left, mid, right);
            count %= 1_000_000_007;
        }
        return count;
    }

    private static long mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = java.util.Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = java.util.Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        long count = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                // All remaining elements in leftArr form inversions with rightArr[j]
                count += (leftArr.length - i);
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return count;
    }
}


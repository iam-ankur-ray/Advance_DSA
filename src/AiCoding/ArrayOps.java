package AiCoding;

public class ArrayOps {
    /** Return the maximum sum of any contiguous subarray of exactly size
     *  k, using a fixed-size sliding window. */
    public static int maxSumSubarrayOfSizeK(int[] arr, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    /** Return a prefix-sum array where prefix[i] is the sum of the first
     *  i elements of arr (prefix[0] == 0). */
    public static int[] computePrefixSums(int[] arr) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        return prefix;
    }

    /** Return the sum of arr[left..right] (inclusive) using a
     *  precomputed prefix-sum array. */
    public static int rangeSum(int[] prefix, int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    /** Return the sum of the sums of every contiguous subarray of arr,
     *  using the contribution technique: each element arr[i] appears in
     *  (i + 1) * (n - i) different subarrays, so its total contribution
     *  to the grand total is arr[i] * (i + 1) * (n - i). */
    public static long totalSubarraySum(int[] arr) {
        int n = arr.length;
        long total = 0;
        for (int i = 0; i < n; i++) {
            long timesIncluded = (long) (i + 1) * (n - i);
            total += arr[i] * timesIncluded;
        }
        return total;
    }
}

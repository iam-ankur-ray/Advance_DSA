package DSA1.binarySearch;

public class MedianProblem {
    public static void main(String[] args) {
        System.out.println(getMedianOfTwoArray(new int[]{-1,-2,-5,9,-13}, new int[] {5,-8,16,-18}));
    }
    public static int getMedianOfTwoArray(int[] A, int[] B) {
        return median(A, B);
    }

    public static int median(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            throw new IllegalArgumentException("Arrays must not be null");
        }

        // Binary-search the shorter array to keep the search efficient.
        int[] smallerArray = firstArray;
        int[] largerArray = secondArray;

        if (smallerArray.length > largerArray.length) {
            smallerArray = secondArray;
            largerArray = firstArray;
        }

        int totalSize = smallerArray.length + largerArray.length;

        if (totalSize == 0) {
            throw new IllegalArgumentException("At least one array must be nonempty");
        }

        int leftSideSize = (totalSize + 1) / 2;
        int low = 0;
        int high = smallerArray.length;

        while (low <= high) {
            int valuesFromSmaller = low + (high - low) / 2;
            int valuesFromLarger = leftSideSize - valuesFromSmaller;

            long smallerLeft = leftValue(smallerArray, valuesFromSmaller);
            long smallerRight = rightValue(smallerArray, valuesFromSmaller);
            long largerLeft = leftValue(largerArray, valuesFromLarger);
            long largerRight = rightValue(largerArray, valuesFromLarger);

            if (isValidPartition(smallerLeft, smallerRight, largerLeft, largerRight)) {
                return medianFromPartition(
                        totalSize,
                        smallerLeft,
                        smallerRight,
                        largerLeft,
                        largerRight
                );
            }

            if (tooManyValuesFromSmaller(smallerLeft, largerRight)) {
                high = valuesFromSmaller - 1;
            } else {
                low = valuesFromSmaller + 1;
            }
        }

        throw new IllegalArgumentException("Both arrays must be sorted");
    }

    private static long leftValue(int[] array, int numberTaken) {
        if (numberTaken == 0) {
            return Long.MIN_VALUE; // Nothing was taken, so this side has no real value.
        }
        return array[numberTaken - 1];
    }

    private static long rightValue(int[] array, int numberTaken) {
        if (numberTaken == array.length) {
            return Long.MAX_VALUE; // Everything was taken, so this side has no real value.
        }
        return array[numberTaken];
    }

    private static boolean isValidPartition(
            long smallerLeft,
            long smallerRight,
            long largerLeft,
            long largerRight
    ) {
        return smallerLeft <= largerRight && largerLeft <= smallerRight;
    }

    private static boolean tooManyValuesFromSmaller(
            long smallerLeft,
            long largerRight
    ) {
        return smallerLeft > largerRight;
    }

    private static int medianFromPartition(
            int totalSize,
            long smallerLeft,
            long smallerRight,
            long largerLeft,
            long largerRight
    ) {
        long largestOnLeft = largerLeft;
        if (smallerLeft > largestOnLeft) {
            largestOnLeft = smallerLeft;
        }

        // Odd total: the extra value is on the left.
        if (totalSize % 2 == 1) {
            return (int) largestOnLeft;
        }

        long smallestOnRight = largerRight;
        if (smallerRight < smallestOnRight) {
            smallestOnRight = smallerRight;
        }

        long middleSum = largestOnLeft + smallestOnRight;

        // Java's integer division truncates toward zero. floorDiv rounds down,
        // which matches the problem for negative medians too.
        return (int) Math.floorDiv(middleSum, 2);
    }
}

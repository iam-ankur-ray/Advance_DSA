package DSA1.binarySearch;

public class FindSingleElement {
    public static void main(String[] args) {
        int[] A = {5,5,6,6,7,7,11,11,12};
        System.out.println(uniqueElement(A));
    }

    public static int uniqueElement(int[] A){
        if (A == null || A.length == 0 || A.length % 2 == 0) {
            return -1;
        }

        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((mid & 1) == 1) mid--;

            if (A[mid] == A[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return A[left];
    }
}

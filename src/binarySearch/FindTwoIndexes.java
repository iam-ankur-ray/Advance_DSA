package binarySearch;

public class FindTwoIndexes {
    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int[] ans = getFirstAndLastOccurrence(A, 8);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    /**
     * Find the index of first and last occurrence of element B in array A
     * @param A array and int B
     * @return array of integer with two values.
     */
    public static int[] getFirstAndLastOccurrence(int[] A, int B){
        int left = 0, right = A.length - 1, mid = 0;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        while(left <= right){
            mid = left + (right - left)/2;

            if((mid == 0 || A[mid - 1] < B) && A[mid] == B){
                ans[0] = mid;
            } else if(A[mid] < B){
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if((mid == A.length - 1 || A[mid + 1] > B) && A[mid] == B){
                ans[1] = mid;
            } else if(A[mid] > B){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            if(mid == 0){
                break;
            }
        }

        return ans;
    }
}

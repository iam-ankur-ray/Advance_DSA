package DSA1.binarySearch;

public class PeakElement {
    public static void main(String[] args) {
        testFindPeakAscending();
        testFindPeakElement();
        testFindPeakSingle();
    }


    public static void testFindPeakElement() {
        int[] singlePeak = {1, 3, 20, 4, 1, 0};
        int idx = findPeakElement(singlePeak);
        assert idx == 2
                : "peak of {1,3,20,4,1,0} should be index 2, got " + idx;
        System.out.println("PASS: testFindPeakElement");
    }

    public static void testFindPeakAscending() {
        int[] increasing = {1, 2, 3, 4, 5};
        int idx = findPeakElement(increasing);
        assert idx == 4
                : "peak of strictly increasing array should be the last index, got " + idx;
        System.out.println("PASS: testFindPeakAscending");
    }

    public static void testFindPeakSingle() {
        int[] single = {7};
        assert findPeakElement(single) == 0
                : "single-element array's peak should be index 0";
        System.out.println("PASS: testFindPeakSingle");
    }

    private static int findPeakElement(int[] arr) {
        int size = arr.length;

        if(size == 1){
            return 0;
        }

        int left = 0, right = size - 1, ans = -1;

        while(left < right){
            int mid = left + (right - left)/2;

            if((mid == 0 || arr[mid] > arr[mid+1]) &&
            (mid == size - 1 || arr[mid] > arr[mid-1])){
                ans = mid;
                left = mid -1;
            } else if(arr[mid] < arr[mid+1]){
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return ans;
    }
}

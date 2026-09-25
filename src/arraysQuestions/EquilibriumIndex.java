package arraysQuestions;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(getEquilibriumIndex(arr));
    }

    /**
     * Find the index of the array from which sum of all elements to the left is equal to the sum of all elements to the right.
     * @param arr of integers
     * @return index value.
     */
    public static int getEquilibriumIndex(int[] arr){
        int size = arr.length;
        int totalSum = 0;

        for(int value: arr){
            totalSum += value;
        }

        int leftSum = 0;
        for(int i = 0; i < size; i++){
            totalSum -= arr[i];
            if(leftSum==totalSum) return i;
            leftSum += arr[i];
        }

        return -1;
    }
}

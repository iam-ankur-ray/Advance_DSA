package mathamatics;

public class Modular {
    public static void main(String[] args) {
        int[] arr = {17, 100, 11};
        System.out.println(getSumOfAllPairsWithMod(arr));
    }

    /**
     * Value of arrays is between 1 and 1000;
     * @param A array
     * @return sum of all pairs A[i]% A[j]
     */
    public static int getSumOfAllPairsWithMod(int[] A){
        final int MODE = 1000000007;

        int max = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] > max){
                max = A[i];
            }
        }
        int[] freq = new int[max+1];
        for(int i = 0; i < A.length; i++){
            freq[A[i]]++;
        }

        long ans = 0;
        for(int i = 1; i <= max; i++){
            int currentSum = 0;
            int pairs = 0;
            for(int j = 1; j <= max; j++){
                currentSum = i % j;
                pairs = freq[i] * freq[j];
                ans += (long) currentSum * pairs;
            }
        }

        return (int) ans % MODE;
    }
}

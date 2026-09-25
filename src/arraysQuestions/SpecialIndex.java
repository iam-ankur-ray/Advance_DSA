package arraysQuestions;

public class SpecialIndex {
    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4};
        System.out.println(getSpecialIndex(arr));
    }

    /**
     * Return the count of array indices such that removing an element from these indices
     * makes the sum of even-indexed and odd-indexed array elements equal.
     *
     */
    public static int getSpecialIndex(int[] a){
        int size = a.length;
        int ans = 0;

        int[] pfe = new int[size];
        int[] pfo = new int[size];

        pfe[0] = a[0];
        pfo[0] = 0;
        for(int i = 1; i < size; i++){
            if(i % 2 == 0){
                pfe[i] = pfe[i - 1] + a[i];
                pfo[i] = pfo[i-1];
            } else {
                pfo[i] = pfo[i-1] + a[i];
                pfe[i] = pfe[i-1];
            }
        }

        int so = 0, se = 0;
        for(int i = 0; i < size; i++){
            if(i==0){
                so = pfe[size - 1] - pfe[i];
                se = pfo[size - 1] - pfo[i];
            } else {
                so = pfo[i-1] + (pfe[size - 1] - pfe[i]);
                se = pfe[i-1] + (pfo[size - 1] - pfo[i]);
            }

            if(so == se){
                ans++;
            }
        }

        return ans;
    }
}

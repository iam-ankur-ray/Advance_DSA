package mathamatics;

public class DeleteOne {
    /**
     * Understand the core logic too.
     * @param A
     * @return
     */
    public int removeOne(int[] A) {
        int size = A.length;
        int[] prefix = new int[size];
        prefix[0] = A[0];
        int current_gcd = A[0];

        for(int i = 1; i < size; i++){
            current_gcd = gcd(current_gcd,A[i]);
            prefix[i] = current_gcd;
        }

        int[] suffix = new int[size];
        current_gcd = A[size - 1];
        suffix[size - 1] = A[size - 1];
        for(int i = size - 2; i >=0; i--){
            current_gcd = gcd(current_gcd,A[i]);
            suffix[i] = current_gcd;
        }

        int max = suffix[1];
        for(int i = 1; i < size-1; i++){
            current_gcd = gcd(prefix[i-1], suffix[i+1]);
            max = Math.max(max, current_gcd);
        }

        return Math.max(max, prefix[size - 2]);
    }

    public static int gcd(int A, int B){
        if(A < B){
            return gcd(B,A);
        }

        if(B==0){
            return A;
        }

        return gcd(B, A % B);
    }
}

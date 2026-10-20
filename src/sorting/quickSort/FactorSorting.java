package sorting.quickSort;

import java.util.Arrays;

public class FactorSorting {
    public static void main(String[] args) {
        int[] A = {13,7, 39,43, 37, 26, 27, 28, 36};
        int[] B = sortByFactor(A);
        for(int i : B){
            System.out.print(i + " ");
        }
    }

    private static int[] sortByFactor(int[] A){
        Integer[] B = new Integer[A.length];
        for(int i = 0; i < A.length; i++){
            B[i] = A[i];
        }
        Arrays.sort(B, (a,b)-> {
                    int c = countFactors(a) - countFactors(b);
                    if(c!=0){
                        return c;
                    } else {
                        return a - b;
                    }
        });
        int index = 0;
        for(Integer i : B){
            A[index] = i;
            index++;
        }

        return A;
    }

    private static int countFactors(int n){
        int count = 0;

        for(int i = 1; i < Math.sqrt(n); i++){
            if(n % i == 0){
                if(i == n/i){
                    count++;
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }
}

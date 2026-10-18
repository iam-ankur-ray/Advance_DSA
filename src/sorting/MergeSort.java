package sorting;

import static Helper.OneDArray.printOneDArray;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = {2,3};
        int[] B =  {1,4};
        int[] C = mergeSortedArrays(A,B);
        printOneDArray(C);
    }

    public static int[] mergeSort(int[] A, int m, int s, int e){
        int size = A.length;

        if(size==1) return A;

        m = (s + e)/2;
        s = 0;
        e = size - 1;

        int[] B = new int[m];
        int[] C = new int[s-m+1];

        for(int i = 0; i < m; i++){
            B[i] = A[i];
        }

        for(int i = m; i < size; i++){
            C[i] = A[i];
        }

        A = mergeSort(A,m,s,e/2);
        int[] ans = mergeSortedArrays(B,C);

        return ans;
    }

    public static int[] mergeSortedArrays(int[] A, int[] B){
        int i = 0, j = 0, k = 0;
        int[] sortedArray = new int[A.length + B.length];

        while(i < A.length && j < B.length){
            if(A[i] <= B[j]){
                sortedArray[k] = A[i];
                i++;
                k++;
            } else {
                sortedArray[k] = B[j];
                j++;
                k++;
            }
        }

        while(i < A.length){
            sortedArray[k] = A[i];
            i++;
            k++;
        }

        while(j < B.length){
            sortedArray[k] = B[j];
            j++;
            k++;
        }

        return sortedArray;
    }
}

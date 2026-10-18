package sorting;

public class MergeSortSolution {
    public static void main(String[] args) {
        int[] A = {1,5,6,4,2,8,13};
        int[] ans = finalSort(A);

        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    public static int[] finalSort(int[] A) {
        int size = A.length;
        return mergeSort(A,0,size-1);
    }

    public static int[] mergeSort(int[]A, int l, int r){
        if(l >= r){
            return A;
        }

        int m = (l + r)/2;
        mergeSort(A, l, m);
        mergeSort(A,m+1,r);
        return merge(A,l,m,r);

    }

    public static int[] merge(int[] A, int s, int m, int r){
        int M = m - s + 1;
        int N = r - m;
        int[] B = new int[M];
        int[] C = new int[N];

        for(int i = s; i <= m;i++){
            B[i-s] = A[i];
        }

        for(int i = m+1; i <= r; i++){
            C[i-m-1] = A[i];
        }

        int i = 0, j = 0, k = s;
        while(i < M && j < N){
            if(B[i] <= C[j]){
                A[k] = B[i];
                i++;
            } else {
                A[k] = C[j];
                j++;
            }

            k++;
        }

        while(i < M){
            A[k] = B[i];
            i++;
            k++;
        }

        while(j < N){
            A[k] = C[j];
            j++;
            k++;
        }

        return A;
    }
}


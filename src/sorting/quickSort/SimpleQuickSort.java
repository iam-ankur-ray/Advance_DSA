package sorting.quickSort;

import javax.swing.plaf.basic.BasicTreeUI;

public class SimpleQuickSort {
    public static void main(String[] args) {
        int[] A = {2, 2, 2, 2, 2, 2};
        quickSort(A,0,5);
        for(int i : A){
            System.out.println(i + " ");
        }
    }
    
    private static int[] quickSort(int[] A, int l, int r){
        if(l >= r){
            return A;
        }

        int p = partition(A,l,r);
        quickSort(A,l,p-1);
        quickSort(A,p+1,r);
        return A;
    }


    private static int partition(int[] A, int l, int r){
        int randomIndex = (int) (Math.random() * ((r - l) + 1)) + l;
        int t = A[l];
        A[l] = A[randomIndex];
        A[randomIndex] = t;

        int pivot = A[l];
        int index = l;
        l++;

        while(l <= r){

            if(A[l] <= pivot){
                l++;
            } else if (A[r] > pivot) {
                r--;
            } else {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
            }
        }
        
        int temp = A[index];
        A[index] = A[r];
        A[r] = temp;
        
        return r;
    }
}

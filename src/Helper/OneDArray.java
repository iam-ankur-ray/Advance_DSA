package Helper;

import java.util.Scanner;

public class OneDArray {

    public static void main(String[] args) {
       int[] A = generateOneDArray();
       printOneDArray(A);
    }

    public static int[] generateOneDArray(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();
        int[] A = new int[size];

        for(int i = 0; i < size; i++){
            System.out.println("Enter the element number " + (i+1));
            int input = sc.nextInt();
            A[i] = input;
        }
        System.out.println("Your generated array is : ");
        printOneDArray(A);
        System.out.println();
        return A;
    }

    public static void printOneDArray(int[] A){
        for(int i : A){
            System.out.print(i + " ");
        }
    }
}

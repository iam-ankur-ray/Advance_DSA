package numbers;

public class AddOne {
    public static void main(String[] args) {
        int[] A = {4,5,8,9};
        int[] B = {9,9,9,9};
        int[] C = {4,5,6};
        int[] D = {4,5,9,9};

        int[] answer = addOne(C);
        for(int values : answer){
            System.out.print(values + " ");
        }
    }

    public static int[] addOne(int[] A){
        int size = A.length;

        if(isAllNine(A)){
            int[] ans = new int[size + 1];
            ans[0] = 1;
            return ans;
        }

        if(A[size-1]!=9){
            A[size-1] += 1;
            return A;
        }

        int i = size - 1;
        while(A[i] == 9){
            A[i] = 0;
            i--;
        }

        A[i] += 1;

        return A;
    }

    private static boolean isAllNine(int[] A){
        for(int i = 0; i < A.length; i++){
            if(A[i] != 9){
                return false;
            }
        }

        return true;
    }
}

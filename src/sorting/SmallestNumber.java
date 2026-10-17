package sorting;

public class SmallestNumber {
    public static void main(String[] args) {
        int[] A = {6, 3, 4, 2, 7, 2, 1};
        int[] B = getSmallestDigit(A);

        for(int i : B){
            System.out.print(i + " ");
        }
    }

    public static int[] getSmallestDigit(int[] A){
        int size = A.length, k = 0;
        int[] freq = new int[10];

        for(int i = 0; i < size; i++){
            freq[A[i]]++;
        }

        System.out.println("Frequency counter");
        for(int i : freq){
            System.out.print(i + " ");
        }
        System.out.println();

        int[] answer = new int[size];

        for(int i = 0; i < 10; i++){
            int loop = freq[i];
            while(loop > 0){
                answer[k] = i;
                k++;
                loop--;
            }
        }

        return answer;
    }
}

package bit_manupilation;

public class BenjaminAndXor {
    public static void main(String[] args) {
        int[] A = {3,4,5,10,5};
        int[] B = {1,2,3,4};
        int[] C = getXorOfBthBits(A,B);
        for(int i : C){
            System.out.print(i + " ");
        }
    }

    public static int[] getXorOfBthBits(int[] A, int[] B){
        int size = A.length;
        int[] answer = new int[B.length];

        int j = 0;
        for(int b : B){
            int x = 0, y = 0;
            for(int i = 0; i < size; i++){
                if(((A[i] >> b) & 1) > 0){
                    x++;
                } else {
                    y++;
                }
            }

            answer[j] = x * y;
            j++;
        }

        return answer;
    }
}

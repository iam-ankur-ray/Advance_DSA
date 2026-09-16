package bit_manupilation;

public class BitsCount {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(getCount(arr));
    }

    public static int getCount(int[] arr){
        int answer = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                answer += Integer.bitCount(arr[i] ^ arr[j]);
            }
        }

        return answer;
    }
}

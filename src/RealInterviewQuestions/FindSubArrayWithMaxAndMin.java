package RealInterviewQuestions;

public class FindSubArrayWithMaxAndMin {
    public static void main(String[] args) {
        int[] A = {9, 1, 1,9, 6, 9, 2, 4, 9};
        int ans = getMaxMinSubArray(A);
        System.out.println(ans);
    }

    public static int getMaxMinSubArray(int[] A) {
        int size = A.length;
        int globalMax = Integer.MIN_VALUE, globalMin = Integer.MAX_VALUE;
        for (int i : A) {
            if (i > globalMax) {
                globalMax = i;
            }

            if (i < globalMin) {
                globalMin = i;
            }
        }

        int ans = size;
        int i = 0, j = 0;
        while(i < size){
            if(A[i] == globalMax || A[i] == globalMin){
                j = i;

                while(j < size){
                    if(A[j] == globalMax || A[j] == globalMin){
                        if(A[i] != A[j]){
                            ans = Math.min(ans, j - i + 1);
                        }
                    }
                    j++;
                }
            }

            i++;
        }

        return ans;

    }
}

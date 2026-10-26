package arraysQuestions;

public class CountIntersection {
    /**
     * We have an array with certain condition for inclustion and exclustion of start and end and we need to find the
     * count of pairs which cannot be merged.
     * @param A array of array with different intervals with type on 1st index.
     * @return count of the intervals which cannot be merged.
     */
    public int excludedIntersections(int[][] A) {
        int size = A.length;
        double[][] interval = new double[size][3];

        for(int i = 0; i < size; i++){
            interval[i][0] = A[i][0];
            interval[i][1] = A[i][1];
            interval[i][2] = A[i][2];
        }

        for(int i = 0; i < size; i++){
            int type = (int) interval[i][0];

            if(type == 2 || type == 4){
                interval[i][2] -= 0.1;
            }

            if(type == 3 || type == 4){
                interval[i][1] += 0.1;
            }
        }

        int count = 0;

        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if(!(interval[i][2] < interval[j][1] || interval[j][2] < interval[i][1])){
                    count++;
                }
            }
        }

        return count;
    }
}

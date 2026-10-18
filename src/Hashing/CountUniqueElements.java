package Hashing;

import java.util.HashMap;

import static Helper.OneDArray.printOneDArray;

public class CountUniqueElements {
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2};
        int[] B = getCountWithinWindow(A,1);
        printOneDArray(B);
    }

    /**
     * Count the unique elements in an array within window of size B
     */
    public static int[] getCountWithinWindow(int[] A, int B){
        int size = A.length;
        if(B > size){
            return new int[0];
        }

        int answerSize = size - B + 1;
        int[] answer = new int[answerSize];

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < B; i++){
            hm.put(A[i], hm.getOrDefault(A[i],0)+1);
        }

        answer[0] = hm.size();

        for(int i = B; i < size; i++){
            int elementToRemove = A[i-B];
            int elementToAdd = A[i];

            if(hm.containsKey(elementToRemove)){
                hm.put(elementToRemove, hm.get(elementToRemove)-1);
                if(hm.get(elementToRemove)==0){
                    hm.remove(elementToRemove);
                }
            }

            hm.put(elementToAdd,hm.getOrDefault(elementToAdd,0)+1);
            answer[i-B+1] = hm.size();
        }



        return answer;
    }
}

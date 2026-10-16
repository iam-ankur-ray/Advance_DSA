package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class checkSumZero {
    public static void main(String[] args) {

    }

    public int isSum0SubArray(int[] A) {
        int size = A.length;
        long[] prefix = new long[size];
        prefix[0] = A[0];
        for (int i = 1; i < size; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }

        HashSet<Long> hs = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (prefix[i] == 0) {
                return 1;
            }

            hs.add(prefix[i]);

        }


        if (hs.size() < size) {
            return 1;
        }


        return 0;

    }

    public static int isSum0(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        int size = A.length;
        int sum = 0;
        for (int i : A) {
            sum += i;

            if (sum == 0) {
                return 1;
            }

            hs.add(sum);
        }

        if (hs.size() < size) {
            return 1;
        }

        return 0;
    }

    public int getCountOfSumB(int[] A, int B) {
        HashMap<Long, Integer> hs = new HashMap<>();
        int size = A.length;
        long sum = 0;
        int count = 0;
        for (int i : A) {
            sum += i;

            if (hs.containsKey(sum - B)) {
                count += hs.get(sum - B);
            }

            if (sum == B) {
                count++;
            }

            hs.put(sum, hs.getOrDefault(sum, 0) + 1);

        }

        return count;
    }

    public int longestConsecutive(final int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i : A){
            hs.add(i);
        }

        int ans = 0;
        int start = 0;

        for(int i : hs){
            if(!hs.contains(i - 1)){
                int count = 0;
                start = i;
                while(hs.contains(start)){
                    count++;
                    start++;
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}

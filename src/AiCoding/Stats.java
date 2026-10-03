package AiCoding;

import java.util.HashMap;
import java.util.Map;

public class Stats {
    /** Return a summary map with min, max, and sum of the array. */
    public static Map<String, Integer> summarize(int[] arr) {
        Map<String, Integer> summary = new HashMap<>();
        if (arr.length == 0) {
            summary.put("min", 0);
            summary.put("max", 0);
            summary.put("sum", 0);
            return summary;
        }
        int min = arr[0];
        int max = arr[0];
        int sum = 0;
        for (int val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            sum += val;
        }
        summary.put("min", min);
        summary.put("max", max);
        summary.put("sum", sum);
        return summary;
    }
}

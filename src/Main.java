import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] A = solve(10);
        for(int i : A){
            System.out.println(i);
        }
    }

        public static int[] solve(int A) {
                int[] answer = new int[A];

                // usedBy[i] stores values assigned to proper divisors of i.
                boolean[][] usedBy = new boolean[A + 1][20];

                for (int i = 1; i <= A; i++) {
                    int value = 1;
                    while (usedBy[i][value]) {
                        value++;
                    }

                    answer[i - 1] = value;

                    // This value is forbidden for every proper multiple of i.
                    for (int multiple = 2 * i; multiple <= A; multiple += i) {
                        usedBy[multiple][value] = true;
                    }
                }

                return answer;
            }
}
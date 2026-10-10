package recursion;

public class Basics {
    public static void main(String[] args) {
        //System.out.println(foo(3,5));
        bar(9);
    }

    public static int getSum(int n) {
        if (n == 1) {
            return 1;
        }

        return getSum(n - 1) + n;
    }

    public static int getFactorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        return getFactorial(n - 1) * n;
    }

    public static void printInc(int n) {
        if (n == 0) {
            return;
        }

        printInc(n - 1);
        System.out.print(n + " ");


    }

    /**
     * Printing number in decreasing order
     *
     * @param n
     */
    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n);
        printDec(n - 1);
    }

    public static void bar(int x) {
        if (x == 0){
            System.out.print(x + " ");
            System.out.println();
            return;
        }

        bar(x-1);
        System.out.println(x + " ");
    }
}

package recursion;

public class Basics {
    public static void main(String[] args) {
        printInc(5);
    }

    public static int getSum(int n){
        if(n==1){
            return 1;
        }

        return getSum(n-1) + n;
    }

    public static int getFactorial(int n){
        if(n==1 || n == 0){
            return 1;
        }

        return getFactorial(n - 1) * n;
    }

    public static void printInc(int n){
        if(n==1){
            System.out.println(1);
            return;
        }

        printInc(n-1);
        System.out.println(n);
    }
}

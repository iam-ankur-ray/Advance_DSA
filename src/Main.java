import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(getSize(new int[]{4,1,0,1,1,1,0},4));
    }

    public static int getSize(int[] a, int k){
        int l = 0, size = a.length, L = 0;
        int sum = 0;
        for(int i = 0; i < size; i++){
            sum += a[i];
            l++;

            L = Math.max(L,l);

            if(sum >= k){
                l = 0;
                sum = 0;
            }
        }
        return L;
    }


}

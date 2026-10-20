import java.util.Arrays;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Integer[] A = {3, 30, 34, 5, 9};
        String[] B = new String[A.length];
        for(int i = 0; i < A.length; i++){
            B[i] = A[i].toString();
        }

        System.out.println("Array as String of B");
        for(String i : B){
            System.out.print(i + " ");
        }

        StringBuilder sb = new StringBuilder();
        System.out.println();
        System.out.println("Arrays after sorting in B");
        Arrays.sort(B, (a,b)-> (b+a).compareTo(a+b));

        for(String i : B){
            sb.append(i);
        }
        Integer ans = Integer.parseInt(sb.toString());;
        System.out.println(ans);
    }
}
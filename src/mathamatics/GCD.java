package mathamatics;

public class GCD {
    public static void main(String[] args) {
        System.out.println(getGCD(6816621,8157697));
        System.out.println(8157697-6816621);
        //System.out.println(getGCD(8,16));
        int[] arr = {5,5,25,63,14,85,97};

        int ans = arr[0];

        for(int i = 0; i < arr.length; i++){
            ans = getGCD(ans,arr[i]);
        }

      //  System.out.println(ans);

    }

    public static int getGCD(int a, int b){
        if(a < b){
            return  getGCD(b,a);
        }

        if(b==0){
            return a;
        }

        return getGCD(b, a % b);
    }
}

package recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of disc : ");
        int disc = sc.nextInt();
        int size = (int) Math.pow(2,disc) - 1;
        int[][] answer = new int[size][3];
        towerOfHanoi(disc, 1, 3,2, answer, new int[]{0});
        System.out.println("Steps involved are : ");
        for(int i = 0; i < size; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void towerOfHanoi(int disc, int start, int end, int mid, int[][] answer, int[] index){
      if(disc == 0) {return;}

      towerOfHanoi(disc-1,start, mid, end, answer, index);
      answer[index[0]][0] = disc;
      answer[index[0]][1] = start;
      answer[index[0]][2] = end;
      index[0]++;
      towerOfHanoi(disc-1, mid, end, start, answer, index);
    }
}

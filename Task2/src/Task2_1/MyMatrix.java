package Task2_1;

import java.util.Random;

import static java.lang.Math.abs;

/**
 * Created by Boris on 21.10.2017.
 */
public class MyMatrix {

    public static void taskA(){
        int [][] a = new int[8][8];
        Random rand = new Random();
        for (int i = 0; i < 8; i++)
            for(int j =0; j<8; j++)
                a[i][j] = rand.nextInt(99)+ 1;
        int sum1=0, sum2 =0;
        long mult1=1, mult2=1;
        for (int i = 0; i < 8; i++){
            sum1+=a[i][i];
            sum2+=a[i][7-i];
            mult1*=a[i][i];
            mult2*=a[i][7-i];
        }
        System.out.println("Summ main diagonal "+sum1);
        System.out.println("Mult main diagonal "+mult1);
        System.out.println("Summ secondary diagonal "+sum2);
        System.out.println("Mult secondary diagonal "+mult2);

        System.out.println();
    }

    public static void taskB(){
        int [][] a = new int[8][5];
        Random rand = new Random();
        int imax=0, jmax=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = rand.nextInt(199) - 99;
                System.out.print(a[i][j]+" ");
                if(a[imax][jmax]<a[i][j]){
                    imax = i;
                    jmax = j;
                }
            }
            System.out.println();
        }
        System.out.println("Max element: a["+imax+"]["+jmax+"] = "+a[imax][jmax]);

        System.out.println();
    }

    public static void taskC(){
        int [][] a = new int[8][5];
        Random rand = new Random();
        long max=1;
        int imax =0;
        for (int i = 0; i < 8; i++) {
            long tmp=1;
            for (int j = 0; j < 5; j++) {
                a[i][j] = rand.nextInt(21) - 10;
                System.out.print(a[i][j]+" ");
                tmp*=a[i][j];
            }
            if(abs(max)<abs(tmp)){
                max = tmp;
                imax = i;
            }
            System.out.println();
        }
        System.out.println("Row with max mult: " + imax);

        System.out.println();
    }

    public static void taskD(){
        int [][] a = new int[10][7];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                a[i][j] = rand.nextInt(101);
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
            for (int j = 0; j < 7; j++){
                int imin=0, k=0;
                for (k = 0; k < 7-j-1; k++)
                if(a[i][imin]>a[i][k+1])imin=k+1;
                int tmp = a[i][k];
                a[i][k] = a[i][imin];
                a[i][imin] = tmp;
            }
        }
        System.out.println("\nSorted:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

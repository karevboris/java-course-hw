package Task2_1;

/**
 * Created by Boris on 20.10.2017.
 */
public class MyMath {
    public static void bubleSort(int[] a) {
        long startTime = System.nanoTime();
        boolean flag = true;
        for (int i = 0; (i < a.length) && (flag); i++) {
            flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                int tmp = a[j + 1];
                if (a[j] > a[j + 1]) {
                    flag = true;
                    tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        long time = System.nanoTime() - startTime;
        System.out.println("\nTime bubleSort: " + time);
    }

    public static void selectionSort(int[] a) {
        long startTime = System.nanoTime();
        for (int i = 0; i < a.length; i++) {
            int iMax = 0;
            int j = 0;
            for (j = 0; j < a.length - i - 1; j++) {
                if (a[iMax] < a[j + 1]) iMax = j+1;
            }
            int tmp = a[j];
            a[j] = a[iMax];
            a[iMax] = tmp;
        }
        long time = System.nanoTime() - startTime;
        System.out.println("Time selectSort:" + time);
    }

    public static long factorialLoop(int n){
        long res = 1;
        for (int i=1; i<=n; i++) res*=i;
        return res;
    }

    public static long factorialRecursion(int n){
        if (n==0) return 1;
        else return n * factorialLoop(n-1);
    }

    public static void drawRectangle(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) System.out.print("# ");
            System.out.println();
        }
        System.out.println();
    }

    public static void drawTriangle(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i; j++) System.out.print("# ");
            System.out.println();
        }
        System.out.println();
    }

    public static void drawEmptyRectangle(int size){
        for (int i = 0; i < size; i++) {
            System.out.print("# ");
            for (int j = 1; j < size-1; j++) {
                if ((i==0)||(i==size-1))System.out.print("# ");
                else System.out.print("  ");
            }
            System.out.print("# ");
            System.out.println();
        }
        System.out.println();
    }

    public static void drawFigure(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i==j)||(i==0)||(i==size-1))System.out.print("# ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

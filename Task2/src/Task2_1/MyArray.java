package Task2_1;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Boris on 21.10.2017.
 */
public class MyArray {
    public static void taskA(int size) {
        int[] a = new int[size];
        int[] b = new int[size];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) a[i] = rand.nextInt(50) * 2 + 1;

        Arrays.sort(a);
        for (int i : a) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < a.length; i++) b[i] = a[size - i - 1];
        for (int i : b) System.out.print(i + " ");
        System.out.println("\n");
    }

    public static void taskB() {
        int[] a = new int[20];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) a[i] = rand.nextInt(11);

        int even = 0, odd = 0;
        for (int i : a) {
            if (i % 2 == 0) even++;
            else odd++;
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Чётных: " + even);
        System.out.println("Нечётных: " + odd);
        System.out.println();
    }

    public static void taskC() {
        int[] a = new int[10];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) System.out.print((a[i] = rand.nextInt(100) + 1) + " ");
        System.out.println();
        for (int i = 0; i < a.length; i += 2) {
            a[i + 1] = 0;
            System.out.print(a[i] + " ");
            System.out.print(a[i + 1] + " ");
        }
        System.out.println("\n");
    }

    public static void taskD() {
        int[] a = new int[15];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) System.out.print((a[i] = rand.nextInt(101) - 50) + " ");
        System.out.println();
        int imax = 0, imin = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[imax] <= a[i + 1]) imax = i + 1;
            if (a[imin] >= a[i + 1]) imin = i + 1;
        }
        System.out.println("Max = " + a[imax] + ", index = " + imax);
        System.out.println("Min = " + a[imin] + ", index = " + imin);
        System.out.println("\n");
    }

    public static void taskE() {
        int[] a = new int[10];
        int[] b = new int[10];
        Random rand = new Random();
        int sumA = 0, sumB = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(11);
            b[i] = rand.nextInt(11);
            sumA += a[i];
            sumB += b[i];
        }

        for (int i : a) System.out.print(i + " ");
        System.out.println();

        for (int i : b) System.out.print(i + " ");
        System.out.println("\n");

        sumA /= 10;
        sumB /= 10;

        if (sumA > sumB) System.out.println("Среднее арифмитическое первого массива больше\n");
        else if (sumA == sumB) System.out.println("Среднее арифмитическое массивов равны\n");
        else System.out.println("Среднее арифмитическое второго массива больше\n");
    }

    public static void taskF() {
        int[] a = new int[20];
        Random rand = new Random();
        int count1 = 0, count0 = 0, count_1 = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(3) - 1;
            if (a[i] == 0) count0++;
            if (a[i] == 1) count1++;
            if (a[i] == -1) count_1++;
        }
        int max = count_1;
        String imax = "-1";

        if (max <= count0) {
            if(max == count0) imax += ", 0";
            else imax = "0";
            max = count0;
        }

        if (max <= count1) {
            if(max == count1) imax += ", 1";
            else imax = "1";
            max = count1;
        }
        System.out.println("Числа с максимальным вхождением: " + imax);
    }
}
package Task2_1;

import java.util.Random;

/**
 * Created by Boris on 22.10.2017.
 */
public class MyIfTest {

    public static void test1(MyEnum e){
        long startTime = System.nanoTime();
        if (e==MyEnum.e1) System.out.print("");
        else if (e==MyEnum.e2) System.out.print("");
        else if (e==MyEnum.e3) System.out.print("");
        else if (e==MyEnum.e4) System.out.print("");
        else if (e==MyEnum.e5) System.out.print("");
        else if (e==MyEnum.e6) System.out.print("");
        else if (e==MyEnum.e7) System.out.print("");
        else if (e==MyEnum.e8) System.out.print("");
        else if (e==MyEnum.e9) System.out.print("");
        else if (e==MyEnum.e10) System.out.print("");
        else if (e==MyEnum.e11) System.out.print("");
        else if (e==MyEnum.e12) System.out.print("");
        else if (e==MyEnum.e13) System.out.print("");
        else if (e==MyEnum.e14) System.out.print("");
        else if (e==MyEnum.e15) System.out.print("");
        long time1 = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        switch (e){
            case e1:System.out.print(""); break;
            case e2:System.out.print(""); break;
            case e3:System.out.print(""); break;
            case e4:System.out.print(""); break;
            case e5:System.out.print(""); break;
            case e6:System.out.print(""); break;
            case e7:System.out.print(""); break;
            case e8:System.out.print(""); break;
            case e9:System.out.print(""); break;
            case e10:System.out.print(""); break;
            case e11:System.out.print(""); break;
            case e12:System.out.print(""); break;
            case e13:System.out.print(""); break;
            case e14:System.out.print(""); break;
            case e15:System.out.print(""); break;
        }
        long time2 = System.nanoTime() - startTime;

        System.out.println("Time if-else: " + time1);
        System.out.println("Time switch-case: " + time2);
        System.out.println();
    }

    public static void test2(){
        int[] a = new int[50];
        int[] marker = new int[11];
        Random rand = new Random();
        for (int i=0; i<a.length; i++) a[i] = rand.nextInt(11);
        long startTime = System.nanoTime();
        for (int e:a) {
            if (e == 0) System.out.print("");
            else if (e == 1) System.out.print("");
            else if (e == 2) System.out.print("");
            else if (e == 3) System.out.print("");
            else if (e == 4) System.out.print("");
            else if (e == 5) System.out.print("");
            else if (e == 6) System.out.print("");
            else if (e == 7) System.out.print("");
            else if (e == 8) System.out.print("");
            else if (e == 9) System.out.print("");
            else if (e == 10) System.out.print("");
        }
        long time1 = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int e:a) {
            switch (e) {
                case 0:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 1:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 2:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 3:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 4:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 5:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 6:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 7:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 8:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 9:
                    marker[e]++;
                    System.out.print("");
                    break;
                case 10:
                    marker[e]++;
                    System.out.print("");
                    break;
            }
        }
        long time2 = System.nanoTime() - startTime;

        System.out.println("Time if-else: " + time1);
        System.out.println("Time switch-case: " + time2+"\nMarker: ");
        for (int i:marker) System.out.print(i);
        System.out.println();
    }
}

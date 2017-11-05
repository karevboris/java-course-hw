package Task2_1;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Boris on 20.10.2017.
 */
public class Main {

    public static void main(String[] args) {

        //задание 1

        Random rand = new Random();
        int [] a = new int [200];
        int [] b = new int [200];
        int [] c = new int [200];
        for(int i =0; i<a.length; i++) a[i] = b[i]= c[i] = rand.nextInt(100);
        for (int i:a) System.out.print(i+" ");
        MyMath.bubleSort(a);
        MyMath.selectionSort(b);
        long start = System.nanoTime();
        Arrays.sort(c);
        long end = System.nanoTime();
        System.out.println("Time standSort: " + (end - start));

        System.out.println(Arrays.equals(a,c)&&Arrays.equals(b,c));



        //задание 2

        long startTime = System.nanoTime();
        System.out.println(MyMath.factorialLoop(10));
        long time1 = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        System.out.println(MyMath.factorialRecursion(10));
        long time2 = System.nanoTime() - startTime;
        System.out.println("Time loop factorial: " + time1);
        System.out.println("Time recursion factorial: " + time2);



        //задание3

        MyMath.drawRectangle(4);
        MyMath.drawTriangle(4);
        MyMath.drawEmptyRectangle(4);
        MyMath.drawFigure(5);



        //задание 4
        MyArray.taskA(30);
        MyArray.taskB();
        MyArray.taskC();
        MyArray.taskD();
        MyArray.taskE();
        MyArray.taskF();



        // задание 5

        MyMatrix.taskA();
        MyMatrix.taskB();
        MyMatrix.taskC();
        MyMatrix.taskD();


        //задание 6

        MyIfTest.test1(MyEnum.e15);
        MyIfTest.test2();

    }
}

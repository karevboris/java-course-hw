package Task2_2;

import Task2_1.MyMatrix;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Boris on 22.10.2017.
 */
public class Main {
    public static void main(String[] args) {

        testCollections.testList(100000);
        testCollections.testSet(100000);
        testCollections.testMap(100000);


        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) list.add(i);
        System.out.println(list.get(5));
        System.out.println(list.indexOf(7));
        System.out.println(list.remove(9));
        System.out.println(list.set(1, 9));
        list.add(6, 111);
        Integer a = (Integer)list.toArray()[6];
        System.out.println(a);
        for (Integer i:list) {
            System.out.print(i+" ");
        }
        System.out.println();
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) System.out.print(iter.next()+" ");
        list.clear();
        System.out.println("\n"+list.size());


        MyLinkedList<Integer> test1 = new MyLinkedList<>();
        LinkedList<Integer> test2 = new LinkedList<>();

        long time1 = System.nanoTime();
        for (int i =0;i<10000;i++) test1.add(i);
        long time2 = System.nanoTime();
        for (int i =0;i<10000;i++) test2.add(i);
        long time3 = System.nanoTime();
        System.out.println("Создание:\n" + (time2-time1));
        System.out.println(time3-time2);

        time1 = System.nanoTime();
        test1.get(9000);
        time2 = System.nanoTime();
        test2.get(9000);
        time3 = System.nanoTime();
        System.out.println("Поиск:\n" + (time2-time1));
        System.out.println(time3-time2);

        time1 = System.nanoTime();
        test1.add(10001);
        time2 = System.nanoTime();
        test2.add(10001);
        time3 = System.nanoTime();
        System.out.println("Добавление:\n" + (time2-time1));
        System.out.println(time3-time2);

        time1 = System.nanoTime();
        test1.remove(9000);
        time2 = System.nanoTime();
        test2.remove(9000);
        time3 = System.nanoTime();
        System.out.println("Удаление:\n" + (time2-time1));
        System.out.println(time3-time2);

    }
}

package Task2_2;

import java.util.*;

/**
 * Created by Boris on 22.10.2017.
 */
public class testCollections {
    public static void testList(int n){
        ArrayList<Integer> array = new ArrayList<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();

        int num =100;//количество эксперементов

        long time1 = System.nanoTime();
        for (int i=0; i<n;i++) array.add(i);//array.add(i);

        long time2 = System.nanoTime();
        for (int i=0; i<n;i++) list.add(i);

        long time3 = System.nanoTime();
        for (int i=0; i<num;i++) array.add(0,0);
        long time4 = System.nanoTime();
        for (int i=0; i<num;i++)array.add(n/2,0);
        long time5 = System.nanoTime();
        for (int i=0; i<num;i++)array.add(n,0);

        long time6 = System.nanoTime();
        for (int i=0; i<num;i++)list.add(0,0);
        long time7 = System.nanoTime();
        for (int i=0; i<num;i++)list.add(n/2,0);
        long time8 = System.nanoTime();
        for (int i=0; i<num;i++)list.add(n,0);

        long time9 = System.nanoTime();
        for (int i=0; i<num;i++)array.remove(0);
        long time10 = System.nanoTime();
        for (int i=0; i<num;i++)array.remove(n/2);
        long time11 = System.nanoTime();
        for (int i=0; i<num;i++)array.remove(n);

        long time12 = System.nanoTime();
        for (int i=0; i<num;i++)list.remove(0);
        long time13 = System.nanoTime();
        for (int i=0; i<num;i++)list.remove(n/2);
        long time14 = System.nanoTime();
        for (int i=0; i<num;i++)list.remove(n);
        long time15 = System.nanoTime();

        System.out.println("Время добавления");
        System.out.println("ArrayList:  "+(time2-time1));
        System.out.println("LinkedList: "+(time3-time2));

        System.out.println("Время вставки в ArrayList");
        System.out.println("В начало:   "+(time4-time3)/num);
        System.out.println("В середину: "+(time5-time4)/num);
        System.out.println("В конец:    "+(time6-time5)/num);

        System.out.println("Время вставки в LinkedList");
        System.out.println("В начало:   "+(time7-time6)/num);
        System.out.println("В середину: "+(time8-time7)/num);
        System.out.println("В конец:    "+(time9-time8)/num);

        System.out.println("Время удаления из ArrayList");
        System.out.println("В начале:   "+(time10-time9)/num);
        System.out.println("В середине: "+(time11-time10)/num);
        System.out.println("В конце:    "+(time12-time11)/num);

        System.out.println("Время удаления из LinkedList");
        System.out.println("В начале:   "+(time13-time12)/num);
        System.out.println("В середине: "+(time14-time13)/num);
        System.out.println("В конце:    "+(time15-time14)/num);
    }

    public static void testSet(int n){
        HashSet<Integer> hash = new HashSet<Integer>();
        LinkedHashSet<Integer> linked = new LinkedHashSet<Integer>();
        TreeSet<Integer> tree = new TreeSet<Integer>();

        Random rand = new Random();
        int num =100;

        long time1 = System.nanoTime();
        for (int i=0; i<n;i++) hash.add(rand.nextInt());

        long time2 = System.nanoTime();
        for (int i=0; i<n;i++) linked.add(rand.nextInt());

        long time3 = System.nanoTime();
        for (int i=0; i<n;i++) tree.add(rand.nextInt());

        long time4 = System.nanoTime();
        for (int i=0; i<num;i++) hash.add(0);
        long time5 = System.nanoTime();
        for (int i=0; i<num;i++) hash.add(n/2);
        long time6 = System.nanoTime();
        for (int i=0; i<num;i++) hash.add(n);

        long time7 = System.nanoTime();
        for (int i=0; i<num;i++)linked.add(0);
        long time8 = System.nanoTime();
        for (int i=0; i<num;i++)linked.add(n/2);
        long time9 = System.nanoTime();
        for (int i=0; i<num;i++)linked.add(n);

        long time10 = System.nanoTime();
        for (int i=0; i<num;i++)tree.add(0);
        long time11 = System.nanoTime();
        for (int i=0; i<num;i++)tree.add(n/2);
        long time12 = System.nanoTime();
        for (int i=0; i<num;i++)tree.add(n);

        long time13 = System.nanoTime();
        for (int i=0; i<num;i++) hash.remove(0);
        long time14 = System.nanoTime();
        for (int i=0; i<num;i++) hash.remove(n/2);
        long time15 = System.nanoTime();
        for (int i=0; i<num;i++) hash.contains(n);

        long time16 = System.nanoTime();
        for (int i=0; i<num;i++) linked.remove(0);
        long time17 = System.nanoTime();
        for (int i=0; i<num;i++) linked.remove(n/2);
        long time18 = System.nanoTime();
        for (int i=0; i<num;i++) linked.contains(n);

        long time19 = System.nanoTime();
        for (int i=0; i<num;i++) tree.remove(0);
        long time20 = System.nanoTime();
        for (int i=0; i<num;i++) tree.remove(n/2);
        long time21 = System.nanoTime();
        for (int i=0; i<num;i++) tree.contains(n);
        long time22 = System.nanoTime();

        System.out.println("\n\nВремя добавления (числа от 0 до n-1)");
        System.out.println("HashSet:   "+(time2-time1));
        System.out.println("LinkedSet: "+(time3-time2));
        System.out.println("TreeSet:   "+(time4-time3));

        System.out.println("Время вставки нулевого элемента");
        System.out.println("HashSet:   "+(time5-time4)/num);
        System.out.println("LinkedSet: "+(time8-time7)/num);
        System.out.println("TreeSet:   "+(time11-time10)/num);


        System.out.println("Время вставки элемента n/2");
        System.out.println("HashSet:   "+(time6-time5)/num);
        System.out.println("LinkedSet: "+(time9-time8)/num);
        System.out.println("TreeSet:   "+(time12-time11)/num);

        System.out.println("Время вставки элемента n");
        System.out.println("HashSet:   "+(time7-time6)/num);
        System.out.println("LinkedSet: "+(time10-time9)/num);
        System.out.println("TreeSet:   "+(time13-time12)/num);

        System.out.println("Время удаления нулевого элемента");
        System.out.println("HashSet:   "+(time14-time13)/num);
        System.out.println("LinkedSet: "+(time17-time16)/num);
        System.out.println("TreeSet:   "+(time20-time19)/num);

        System.out.println("Время удаления элемента n/2");
        System.out.println("HashSet:   "+(time15-time14)/num);
        System.out.println("LinkedSet: "+(time18-time17)/num);
        System.out.println("TreeSet:   "+(time21-time20)/num);

        System.out.println("Время удаления элемента n");
        System.out.println("HashSet:   "+(time16-time15)/num);
        System.out.println("LinkedSet: "+(time19-time18)/num);
        System.out.println("TreeSet:   "+(time22-time21)/num);
    }

    public static void testMap(int n) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        LinkedHashMap<Integer,Integer> linked = new LinkedHashMap<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        Random rand = new Random();
        int num = 100;

        long time1 = System.nanoTime();
        for (int i = 0; i < n; i++) hash.put(i,i);

        long time2 = System.nanoTime();
        for (int i = 0; i < n; i++) linked.put(i,i);

        long time3 = System.nanoTime();
        for (int i = 0; i < n; i++) tree.put(i,i);

        long time4 = System.nanoTime();
        for (int i = 0; i < num; i++) hash.put(0,0);
        long time5 = System.nanoTime();
        for (int i = 0; i < num; i++) hash.put(n / 2,0);
        long time6 = System.nanoTime();
        for (int i = 0; i < num; i++) hash.put(n,0);

        long time7 = System.nanoTime();
        for (int i = 0; i < num; i++) linked.put(0,0);
        long time8 = System.nanoTime();
        for (int i = 0; i < num; i++) linked.put(n/2,0);
        long time9 = System.nanoTime();
        for (int i = 0; i < num; i++) linked.put(n,0);

        long time10 = System.nanoTime();
        for (int i = 0; i < num; i++) tree.put(0,0);
        long time11 = System.nanoTime();
        for (int i = 0; i < num; i++) tree.put(n / 2,0);
        long time12 = System.nanoTime();
        for (int i = 0; i < num; i++) tree.put(n,0);

        long time13 = System.nanoTime();
        for (int i = 0; i < num; i++) hash.remove(0);
        long time14 = System.nanoTime();
        for (int i = 0; i < num; i++) hash.remove(n / 2);
        long time15 = System.nanoTime();
        for (int i = 0; i < num; i++) hash.remove(n);

        long time16 = System.nanoTime();
        for (int i = 0; i < num; i++) linked.remove(0);
        long time17 = System.nanoTime();
        for (int i = 0; i < num; i++) linked.remove(n / 2);
        long time18 = System.nanoTime();
        for (int i = 0; i < num; i++) linked.remove(n);

        long time19 = System.nanoTime();
        for (int i = 0; i < num; i++) tree.remove(0);
        long time20 = System.nanoTime();
        for (int i = 0; i < num; i++) tree.remove(n / 2);
        long time21 = System.nanoTime();
        for (int i = 0; i < num; i++) tree.remove(n);
        long time22 = System.nanoTime();

        System.out.println("\n\nВремя добавления (числа от 0 до n-1)");
        System.out.println("HashMap:   " + (time2 - time1));
        System.out.println("LinkedMap: " + (time3 - time2));
        System.out.println("TreeMap:   " + (time4 - time3));

        System.out.println("Время вставки нулевого элемента");
        System.out.println("HashMap:   " + (time5 - time4) / num);
        System.out.println("LinkedMap: " + (time8 - time7) / num);
        System.out.println("TreeMap:   " + (time11 - time10) / num);


        System.out.println("Время вставки элемента n/2");
        System.out.println("HashMap:   " + (time6 - time5) / num);
        System.out.println("LinkedMap: " + (time9 - time8) / num);
        System.out.println("TreeMap:   " + (time12 - time11) / num);

        System.out.println("Время вставки элемента n");
        System.out.println("HashMap:   " + (time7 - time6) / num);
        System.out.println("LinkedMap: " + (time10 - time9) / num);
        System.out.println("TreeMap:   " + (time13 - time12) / num);

        System.out.println("Время удаления нулевого элемента");
        System.out.println("HashMap:   " + (time14 - time13) / num);
        System.out.println("LinkedMap: " + (time17 - time16) / num);
        System.out.println("TreeMap:   " + (time20 - time19) / num);

        System.out.println("Время удаления элемента n/2");
        System.out.println("HashMap:   " + (time15 - time14) / num);
        System.out.println("LinkedMap: " + (time18 - time17) / num);
        System.out.println("TreeMap:   " + (time21 - time20) / num);

        System.out.println("Время удаления элемента n");
        System.out.println("HashMap:   " + (time16 - time15) / num);
        System.out.println("LinkedMap: " + (time19 - time18) / num);
        System.out.println("TreeMap:   " + (time22 - time21) / num);
    }
}



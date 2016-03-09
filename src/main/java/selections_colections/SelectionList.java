package selections_colections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 04.03.2016.
 */
public class SelectionList {

    static List<Integer> arrayList = new ArrayList<>();
    static List<Integer> linkedList = new LinkedList<>();

    static void addArrayList() {
        for (int i = 0; i < 10000; i++)
            arrayList.add(arrayList.size()/2, 10);
    }

    static void addLinkedList() {
        for (int i = 0; i < 10000; i++)
            linkedList.add(linkedList.size()/2, 10);
    }

    static void info() {
        long start = System.nanoTime();
        SelectionList.addArrayList();
        double durationArrayList = (System.nanoTime() - start);
        System.out.println(durationArrayList);

        long start2 = System.nanoTime();
        SelectionList.addLinkedList();
        double durationLinkedList = (System.nanoTime() - start2);
        System.out.println(durationLinkedList);

        double x;
        if (durationArrayList < durationLinkedList) {
            x = durationLinkedList / durationArrayList;
            System.out.printf("При вставке в середину списка из 10000 элементов " +
                    "ArrayList быстрее LinkedList в %6.4f раз", x);
        } else {
            x = durationArrayList / durationLinkedList;
            System.out.printf("При вставке в середину списка из 10000 элементов " +
                    "LinkedList быстрее ArrayList в %6.4f раз", x);
        }
    }

    public static void main(String[] args) {
        SelectionList.info();
    }
}

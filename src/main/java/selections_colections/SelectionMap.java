package selections_colections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by User on 09.03.2016.
 */
public class SelectionMap {

    static Map<Integer, String> hashMap = new HashMap<>();
    static Map<Integer, String> hashtable = new Hashtable<>();

    static void putHashMap() {
        for (int i = 0; i < 10000; i++)
            hashMap.put(hashMap.size()/2, "string");
    }

    static void putHashtable() {
        for (int i = 0; i < 10000; i++)
            hashtable.put(hashtable.size()/2, "string");
    }

    static void info() {
        long start = System.nanoTime();
        SelectionMap.putHashMap();
        double durationHashMap = (System.nanoTime() - start);
        System.out.println(durationHashMap);

        long start2 = System.nanoTime();
        SelectionMap.putHashtable();
        double durationHashtable = (System.nanoTime() - start2);
        System.out.println(durationHashtable);

        double x;
        if (durationHashMap < durationHashtable) {
            x = durationHashtable / durationHashMap;
            System.out.printf("При вставке в середину списка из 10000 элементов " +
                    "HashMap быстрее Hashtable в %6.4f раз", x);
        } else {
            x = durationHashMap / durationHashtable;
            System.out.printf("При вставке в середину списка из 10000 элементов " +
                    "Hashtable быстрее HashMap в %6.4f раз", x);
        }
    }

    public static void main(String[] args) {
        SelectionMap.info();
    }
}
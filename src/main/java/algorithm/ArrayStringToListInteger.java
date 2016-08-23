package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public class ArrayStringToListInteger {
    public static void main (String[] args) {

        String [] array = {"1", "2", "3"};
        List<Integer> list = new ArrayList<>();
        for (String s : array) {
            int x = Integer.parseInt(s);
            list.add(x);
        }

    }
}

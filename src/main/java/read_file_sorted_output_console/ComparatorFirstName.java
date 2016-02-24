package read_file_sorted_output_console;

import java.util.Comparator;

/**
 * Created by User on 24.02.2016.
 */
public class ComparatorFirstName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

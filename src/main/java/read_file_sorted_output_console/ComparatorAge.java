package read_file_sorted_output_console;

import java.util.Comparator;

/**
 * Created by User on 24.02.2016.
 */
public class ComparatorAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        Integer age1 = o1.getAge();
        Integer age2 = o2.getAge();
        return age1.compareTo(age2);
    }
}

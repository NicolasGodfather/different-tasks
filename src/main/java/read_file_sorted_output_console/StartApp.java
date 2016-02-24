package read_file_sorted_output_console;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by User on 24.02.2016.
 */
public class StartApp {

    public static final String KEYWORD_FOR_EXIT = "--stop";

    public static void startApp(PersonsStore personsStore) {
        System.out.println("Enter one of these commands:");
        System.out.println("1) '-f' - sorted by first name person;");
        System.out.println("2) '-s' - sorted by second name person;");
        System.out.println("3) '-a' - sorted by age person.");
        List<Person> persons = personsStore.getPersons();
        try (Scanner sc = new Scanner(System.in);) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (isStopTheApp(line)) {
                    break;
                }
                if (line.equals("-f")) {
                    Collections.sort(persons, new ComparatorFirstName());
                } else if (line.equals("-s")) {
                    Collections.sort(persons, new ComparatorSecondName());
                } else if (line.equals("-a")) {
                    Collections.sort(persons, new ComparatorAge());
                }
                printList(persons);
                System.out.println("Enter one of these commands '-f' '-s' '-a'...");
            }
        }
    }

    private static void printList(List<Person> persons) {
        persons.forEach(System.out::println);
    }

    private static boolean isStopTheApp(String line) {
        return line.equals(KEYWORD_FOR_EXIT);
    }

}

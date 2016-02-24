package read_file_sorted_output_console;

/**
 * Created by User on 24.02.2016.
 */
public class Main {


    public static void main(String[] args) {
        System.out.println("Persons loading...");
        PersonsStore personsStore = new PersonsStore().invoke();
        if (personsStore.wasError()) {
            System.out.println("App was stopped");
            return;
        }
        System.out.println("Persons were loaded.");
        System.out.println("App was started. Enter '" + StartApp.KEYWORD_FOR_EXIT + "' to exit.");

        StartApp.startApp(personsStore);
        System.out.println("App was stopped");
    }

}

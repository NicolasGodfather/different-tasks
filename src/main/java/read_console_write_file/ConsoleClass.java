package read_console_write_file;

import java.io.*;

/**
 * Created by User on 11.02.2016.
 */
public class ConsoleClass {

    public static String FILE_PATH = "store/file.txt";
    public static final String CHARSET_NAME = "UTF-8";
    public static boolean APPEND  = true;
    public static int count;


    public static void main(String[] args) throws IOException {
        ConsoleClass.getConsoleReader();
    }
// added - поиграемся - если в данном месте файл с таким именем существует создаем новый файл
    private static String exists(String fileName) throws FileNotFoundException {
        fileName = FILE_PATH;
        File file = new File(fileName);
        if (file.exists()){
            FILE_PATH = "store/file_" + count++ + ".txt";
        }
        return FILE_PATH;
    }

    public static void getConsoleReader() throws IOException {
        System.out.println("Enter new line...");
        // 1 variant solutions
//        try (Scanner scanner = new Scanner(System.in);) {
//            while (scanner.hasNext()) {
//                String line = scanner.nextLine();
//                if (line.endsWith("-stop")) {
//                    break;
//                }
//                writeNewLine(line);
//            }
        // 2 variant solutions
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (APPEND) {
                String line = reader.readLine();
                writeNewLine(line);
                if (line.endsWith("-stop")) {
                    break;
                }
            }
        }
    }

    public static void writeNewLine(String line) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(exists(FILE_PATH), APPEND);
             OutputStreamWriter output = new OutputStreamWriter(fileOutputStream, CHARSET_NAME);
             PrintWriter printWriter = new PrintWriter(output); )
        {
            printWriter.println(line);
        }
    }

}

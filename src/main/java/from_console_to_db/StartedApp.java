package from_console_to_db;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by User on 24.02.2016.
 */
public class StartedApp {

    public static final String H2_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:E:/JAVA/It-Sphere/different-tasks/src/main/java/from_console_to_db/data/test";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_TEXT = "text";
    public static final String KEYWORD_FOR_EXIT = "--stop";
    public static final String KEYWORD_FOR_ALL_MESSAGES = "--all";
    public static final String INSERT_NEW_MESSAGE = "INSERT INTO mess (author, text) VALUES (?, ?);";
    public static final String ALL_MESSAGES_QUERY = "SELECT * FROM mess;";

    public static void startApp() {
        try {
            Class.forName(H2_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("App was started. Enter '" + KEYWORD_FOR_EXIT + "' to exit.");
        System.out.println("Enter name and message or " + KEYWORD_FOR_ALL_MESSAGES + "...");
        try (Scanner sc = new Scanner(System.in);) {
            while (sc.hasNextLine()) {
                String command = sc.nextLine();
                if (isStopTheApp(command)) {
                    break;
                } else if (isShowAllMessages(command)) {
                    printAllMessages();
                } else {
                    String[] authorAndMessage = command.split(":");
                    if (authorAndMessage.length == 2) {
                        insertMessage(authorAndMessage[0], authorAndMessage[1]);
                    } else {
                        System.out.println("Incorrect command '" + command + "'");
                    }
                }
                System.out.println("Enter name and message or " + KEYWORD_FOR_ALL_MESSAGES + "...");
            }
        }
        System.out.println("App was stopped");
    }

    // ввести Имя и фразу, добавив в БД
    private static void insertMessage(String author, String message) {
        try (Connection connection = DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_MESSAGE);) {
            statement.setString(1, author);
            statement.setString(2, message);
            int rowCount = statement.executeUpdate();
            if (rowCount == 0) {
                throw new RuntimeException("INSERT ERROR");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printAllMessages() {
        try (Connection connection = DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(ALL_MESSAGES_QUERY);) {
            printFetchedMessages(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printFetchedMessages(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String author = resultSet.getString(COLUMN_AUTHOR);
            String text = resultSet.getString(COLUMN_TEXT);
            System.out.println(author + " : " + text);
        }
    }

    private static boolean isStopTheApp(String line) {
        return KEYWORD_FOR_EXIT.equals(line);
    }

    private static boolean isShowAllMessages(String line) {
        return KEYWORD_FOR_ALL_MESSAGES.equals(line);
    }
}

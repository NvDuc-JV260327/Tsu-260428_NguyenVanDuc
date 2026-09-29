package utils;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputData {
    public static int getInt(Scanner scanner, String suggestion) {
        do {
            System.out.print(suggestion);
            try {
                int num =  Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }while (true);
    }

    public static String getString(Scanner scanner, String suggestion) {
        do {
            System.out.print(suggestion);
            String str = scanner.nextLine();
            if(str.isEmpty()) {
                System.out.println("Vui lòng không để trống!");
                continue;
            }
            return str;
        } while (true);
    }

    public static long getLong(Scanner scanner, String suggestion) {
        do {
            System.out.print(suggestion);
            try {
                long num = Long.parseLong(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        } while (true);
    }

    public static Timestamp getTimeStamp(Scanner scanner, String suggestion) {
        do {
            System.out.print(suggestion);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dateTimeStr = scanner.nextLine();
            try {
                Timestamp timestamp = Timestamp.valueOf(dateTimeStr);
                return timestamp;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập đúng định dạng!");
            }
        } while (true);
    }

    public static String getStatus(Scanner scanner, String suggestion) {
        do {
            System.out.print(suggestion);
            String status = scanner.nextLine();
            if(status.equalsIgnoreCase("Borrowing") || status.equalsIgnoreCase("Returned") || status.equalsIgnoreCase("Overdue")) {
                return status;
            } else {
                System.out.println("Vui lòng nhập trạng thái là Borrowing, Returned hoặc Overdue!");
            }
        } while (true);
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class phoneBook {
    public static void main(String[]args) {
        Map<String, String> phoneBook = new HashMap<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Меню:");
                System.out.println("1) Добавить контакт");
                System.out.println("2) Вывести всех");
                System.out.println("3) Выход");

                int select = scanner.nextInt();
                scanner.nextLine();

                if (select == 1) {
                    System.out.print("Введите имя:");
                    String name = scanner.nextLine();
                    System.out.print("Введите номер телефона:");
                    String phoneNumber = scanner.nextLine();

                    if (phoneBook.containsKey(name)) {
                        String existingNumbers = phoneBook.get(name);
                        existingNumbers += ", " + phoneNumber;
                        phoneBook.put(name, existingNumbers);
                    } else {
                        phoneBook.put(name, phoneNumber);
                    }
                } else if (select == 2) {
                    Map<String, String> sortedPhoneBook = new TreeMap<>(phoneBook);

                    for (Map.Entry<String, String> entry : sortedPhoneBook.entrySet()) {
                        String name = entry.getKey();
                        String phoneNumber = entry.getValue();
                        System.out.println(name + ": " + phoneNumber);
                    }
                } else if (select == 3) {
                    break;
                } else {
                    System.out.println("Некорректный набор");
                }
            }
        }
    }
}

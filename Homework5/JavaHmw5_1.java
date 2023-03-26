
package Homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaHmw5_1 {
    /*
     * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
     * человек может иметь несколько телефонов.
     * Добавить функции 1) Добавление номера
     * 2) Вывод всего
     * Пример:
     * Я ввожу: 1
     * К: Введите фамилию
     * Я: Иванов
     * К: Введите номер
     * Я: 1242353
     * К: Введите 1) Добавление номера
     * 2) Вывод всего
     * Я ввожу: 1
     * К: Введите фамилию
     * Я: Иванов
     * К: Введите номер
     * Я: 547568
     * К: Введите 1) Добавление номера
     * 2) Вывод всего
     * Я: 2
     * Иванов: 1242353, 547568
     */
    public static void main(String[] args) {
        Map<String, ArrayList<String>> contactTable = new HashMap<String, ArrayList<String>>();
        Scanner scan = new Scanner(System.in, "CP866");
        System.out.println("Телефонная книга");

        while (true) {
            System.out
                    .print("Введите \"1\", чтобы добавить контакт; \nвведите \"2\" чтобы вывести список контактов >> ");

            String option = scan.next();
            if (option.equals("1"))
                addContact(contactTable, scan);
            else if (option.equals("2"))
                formattedOutput(contactTable);
        }
    }

    public static Map<String, ArrayList<String>> addContact(Map<String, ArrayList<String>> contactTable, Scanner scan) {
        System.out.print("Введите имя >> ");
        String name = scan.next();
        System.out.print("Введите номер телефона >> ");
        ArrayList<String> phoneNumber = new ArrayList<>();

        if (contactTable.containsKey(name)) {
            phoneNumber = contactTable.get(name);
        }
        String phoneTester = "(\\+)?\\d{2,}";
        Pattern phonePattern = Pattern.compile(phoneTester);

        while (true) {
            String phoneInput = scan.next();
            Matcher phoneMatcher = phonePattern.matcher(phoneInput);
            if (phoneMatcher.matches()) {
                phoneNumber.add(phoneInput);
                break;
            } else {
                System.out.print("Формат номера неверен, попробуйте еще раз >> ");
            }
        }
        contactTable.put(name, phoneNumber);
        return contactTable;

    }

    public static void formattedOutput(Map<String, ArrayList<String>> contactTable) {
        if (contactTable.isEmpty()) {
            System.out.println("\nТелефонная книга пока пуста...\n");
        } else {
            System.out.println("\nСписок контактов: ");
            System.out.println(contactTable.toString().replaceAll("=", ": ")
                    .replaceAll("\\], ", "\n")
                    .replaceAll("\\[|\\]|\\{|\\}", ""));
            System.out.println("");
        }

    }

}

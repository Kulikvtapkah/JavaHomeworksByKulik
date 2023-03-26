package Homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


public class JavaHmw5_2 {
    /*
     * Пусть дан список сотрудников:
     * Иван Иванов
     * Светлана Петрова
     * Кристина Белова
     * Анна Мусина
     * Анна Крутова
     * Иван Юрин
     * Петр Лыков
     * Павел Чернов
     * Петр Чернышов
     * Мария Федорова
     * Марина Светлова
     * Мария Савина
     * Мария Рыкова
     * Марина Лугова
     * Анна Владимирова
     * Иван Мечников
     * Петр Петин
     * Иван Ежов
     * 
     * Написать программу, которая найдет и выведет повторяющиеся имена с
     * количеством повторений.
     * Отсортировать по убыванию популярности Имени.
     */
    public static void main(String[] args) {
        ArrayList<String> stuffList = new ArrayList<String>(Arrays.asList(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                "Иван Мечников", "Петр Петин", "Иван Ежов", "Анна Крутова"));

        Map<String, Integer> nameQuantity = new HashMap<String, Integer>();

        for (String name : stuffList) {

            Scanner scan = new Scanner(name);
            String firstName = scan.next();
            if (!nameQuantity.containsKey(firstName)) {
                nameQuantity.put(firstName, 1);
            } else
                nameQuantity.put(firstName, nameQuantity.get(firstName) + 1);
            scan.close();
        }

        LinkedList<String> doubledNames = new LinkedList<String>();
        for (Map.Entry<String, Integer> entry : nameQuantity.entrySet()) {
            if (entry.getValue() > 1) {
                doubledNames.add(entry.getValue() + " чел. с именем " + entry.getKey());
            }
        }
        Collections.sort(doubledNames, Collections.reverseOrder());
        System.out.println("В списке сотрудников: ");
        System.out.println(doubledNames.toString().replaceAll("\\, ", "\n").replaceAll("\\[|\\]", ""));
    }
}

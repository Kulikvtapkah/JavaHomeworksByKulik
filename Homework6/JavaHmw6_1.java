package Homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class JavaHmw6_1 {
    /*
     * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
     * методы. Реализовать в java.
     * Создать множество ноутбуков.
     * Написать метод, который будет запрашивать у пользователя критерий фильтрации
     * и выведет ноутбуки, отвечающие фильтру.
     * NoteBook notebook1 = new NoteBook
     * NoteBook notebook2 = new NoteBook
     * NoteBook notebook3 = new NoteBook
     * NoteBook notebook4 = new NoteBook
     * NoteBook notebook5 = new NoteBook
     * 
     * Например: “Введите цифру, соответствующую необходимому критерию:
     * 1 - ОЗУ
     * 2 - Объем ЖД
     * 3 - Операционная система
     * 4 - Цвет
     * 
     * Далее нужно запросить минимальные значения для указанных критериев -
     * сохранить параметры фильтрации можно также в Map.
     * 
     * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
     * условиям.
     * 
     * Класс сделать в отдельном файле
     * 
     * приветствие
     * Выбор параметра
     * выбор конкретнее
     * вывод подходящих
     */
    public static void main(String[] args) {

        HashSet<NoteBook> laptopSet = new HashSet<NoteBook>();

        laptopSet.add(new NoteBook("Acer", "silver", "Windows", 15.6, 8, 512, 49990));
        laptopSet.add(new NoteBook("Acer", "ivory", 14.0, 8, 480, 42000, true));
        laptopSet.add(new NoteBook("ASUS", "black", "Windows", 16.0, 16, 512, 62990));
        laptopSet.add(new NoteBook("SAMSUNG", "silver", 15.6, 8, 256, 64990, true));
        laptopSet.add(new NoteBook("HP", "dark silver", 15.6, 4, 1000, 25000));
        laptopSet.add(new NoteBook("Lenovo", "black", "Linux", 13.3, 16, 512, 93560, true));
        laptopSet.add(new NoteBook("MSI", "almomd", "Windows", 17.3, 64, 2048, 334500));
        laptopSet.add(new NoteBook("Acer", "gold", 14.0, 8, 512, 79640, true));

        Scanner shopAssistent = new Scanner(System.in);
        System.out.println("\nОтдаем ноутбуки в добрые руки! Выбирай, человек!");
        HashSet<String> choiceParameters = getChoiceParameters(shopAssistent);

        HashMap<String, Object> filter = specifyChoiceParameters(choiceParameters, laptopSet, shopAssistent);

        boolean gotMatch = false;
        int i = 1;
        System.out.println("\nВаша подборка:");
        for (NoteBook noteBook : laptopSet) {
            if (noteBook.isMatch(filter)) {
                System.out.println("\n" + i + ".");
                System.out.println(noteBook.toString());
                i++;
                gotMatch = true;
            }
        }
        if(!gotMatch){
            System.out.println("Увы! Ничего подходящего. Печалька((( \nПопробуйте изменить параметры");
        }
    }

    public static HashSet<String> getChoiceParameters(Scanner shopAssistent) {
        HashSet<String> choiceParameters = new HashSet<String>();
        System.out.println("Определите параметры выбора:");
        System.out.println(
                "1 - бренд\n2 - цвет\n3 - операционная система\n4 - размер экрана\n5 - оперативная память\n6 - объем диска\n7 - цена\n8 - возможность рассрочки");

        System.out.print("Введите цифру из списка (или несколько через пробел) >> ");
        choiceParameters.addAll(Arrays.asList(shopAssistent.nextLine().split(" ")));

        return choiceParameters;

    }

    public static HashMap<String, Object> specifyChoiceParameters(
            HashSet<String> choiceParameters, HashSet<NoteBook> laptopSet, Scanner shopAssistent) {

        HashMap<String, Object> specificChoiceParameters = new HashMap<String, Object>();

        for (String parameter : choiceParameters) {
            TreeSet<String> options = new TreeSet<String>();
            TreeSet<Integer> numberOptions = new TreeSet<Integer>();
            int[] numberRange = { 0, 0 };

            switch (parameter) {
                case "1":
                    options.clear();
                    System.out.println("Выберите бренд");
                    for (NoteBook note : laptopSet) {
                        options.add(note.getBrand());
                    }
                    specificChoiceParameters.put("brand", specifyStringOptions(laptopSet, options, shopAssistent));
                    break;

                case "2":
                    options.clear();
                    System.out.println("Выберите цвет");
                    for (NoteBook note : laptopSet) {
                        options.add(note.getColor());
                    }
                    specificChoiceParameters.put("color", specifyStringOptions(laptopSet, options, shopAssistent));
                    break;

                case "3":
                    options.clear();
                    System.out.println("Выберите операционную систему");
                    for (NoteBook note : laptopSet) {
                        options.add(note.getOS());
                    }
                    specificChoiceParameters.put("OS", specifyStringOptions(laptopSet, options, shopAssistent));
                    break;
                case "4":
                    Double[] screenSizeRange = { 10000., 0. };

                    for (NoteBook note : laptopSet) {
                        if (note.getScreenSize() < screenSizeRange[0]) {
                            screenSizeRange[0] = note.getScreenSize();
                        } else if (note.getScreenSize() > screenSizeRange[1]) {
                            screenSizeRange[1] = note.getScreenSize();
                        }
                    }

                    System.out.println("Выберите диагональ монитора");
                    System.out.printf("Доступны варианты в диапазоне: %s\" - %s\".\n",
                            screenSizeRange[0], screenSizeRange[1]);
                    specificChoiceParameters.put("screenSize",
                            specifyNumbeOptions(laptopSet, screenSizeRange, shopAssistent));

                    break;
                case "5":
                    numberOptions.clear();
                    for (NoteBook note : laptopSet) {
                        numberOptions.add(note.getRAM());
                    }
                    numberRange[0] = numberOptions.first();
                    numberRange[1] = numberOptions.last();
                    System.out.println("Выберите объем оперативной памяти");
                    System.out.printf("Доступны варианты в диапазоне: %s - %s Гб.\n",
                            numberRange[0], numberRange[1]);
                    specificChoiceParameters.put("RAM", specifyNumbeOptions(laptopSet, numberRange, shopAssistent));
                    break;

                case "6":
                    numberOptions.clear();
                    for (NoteBook note : laptopSet) {
                        numberOptions.add(note.getHardDriveSize());
                    }
                    numberRange[0] = numberOptions.first();
                    numberRange[1] = numberOptions.last();
                    System.out.println("Выберите объем диска");
                    System.out.printf("Доступны варианты в диапазоне: %s - %s Гб.\n",
                            numberRange[0], numberRange[1]);
                    specificChoiceParameters.put("hardDriveSize",
                            specifyNumbeOptions(laptopSet, numberRange, shopAssistent));

                    break;
                case "7":
                    numberOptions.clear();
                    for (NoteBook note : laptopSet) {
                        numberOptions.add(note.getPrice());
                    }
                    numberRange[0] = numberOptions.first();
                    numberRange[1] = numberOptions.last();
                    System.out.println("Определите цену");
                    System.out.printf("Доступны варианты в диапазоне: %s - %s руб.\n",
                            numberRange[0], numberRange[1]);
                    specificChoiceParameters.put("price",
                            specifyNumbeOptions(laptopSet, numberRange, shopAssistent));
                    break;
                case "8":
                    System.out.println("Нужна рассрочка?");
                    System.out.print(
                            "Введите \"y\", чтобы найти модели с возможностью рассрочки, (любой другой знак - отмена) >> ");
                    if (shopAssistent.next().equals("y")) {
                        specificChoiceParameters.put("installment", true);
                    }
                default:
                    break;
            }
        }
        return specificChoiceParameters;
    }

    public static TreeSet<String> specifyStringOptions(HashSet<NoteBook> laptopSet, TreeSet<String> options,
            Scanner shopAssistent) {

        ArrayList<String> optionsList = new ArrayList<String>(options);
        System.out.println("Отметьте интересующие вас варианты:");

        for (int i = 0; i < optionsList.size(); i++) {
            System.out.println(i + 1 + " " + optionsList.get(i));
        }
        System.out.print("Введите через пробел цифры их списка >> ");

        HashSet<String> usersChoice = new HashSet<String>(
                Arrays.asList(shopAssistent.nextLine().split(" ")));

        for (int i = 0; i < optionsList.size(); i++) {
            if (!usersChoice.contains(Integer.toString(i + 1))) {
                options.remove(optionsList.get(i));
            }
        }
        System.out.print("Вы выбрали:");
        System.out.println(options.toString());
        return options;

    }

    public static int[] specifyNumbeOptions(HashSet<NoteBook> laptopSet, int[] numberRange,
            Scanner shopAssistent) {

        System.out.println("Изменить верхнюю границу? ");
        System.out.print("Введите целое число или любой знак, чтобы оставить текущее значение >> ");
        try {
            int n = shopAssistent.nextInt();
            if (n < numberRange[1] && n > numberRange[0]) {
                numberRange[1] = n;
            }
        } catch (Exception e) {
            shopAssistent.nextLine();
        }

        System.out.println("Изменить нижнюю границу? ");
        System.out.print("Введите целое число или любой знак, чтобы оставить текущее значение >> ");
        try {
            int n = shopAssistent.nextInt();
            if (n <= numberRange[1] && n > numberRange[0]) {
                numberRange[0] = n;
            }
        } catch (Exception e) {
            shopAssistent.nextLine();
        }

        System.out.printf("Новый диапазон: %s - %s\n", numberRange[0], numberRange[1]);

        return numberRange;

    }

    public static Double[] specifyNumbeOptions(HashSet<NoteBook> laptopSet, Double[] numberRange,
            Scanner shopAssistent) {

        System.out.println("Изменить верхнюю границу? ");
        System.out.print("Введите число или любой знак, чтобы оставить текущее значение >> ");
        try {
            double n = shopAssistent.nextDouble();
            if (n < numberRange[1] && n > numberRange[0]) {
                numberRange[1] = n;
            }
        } catch (Exception e) {
            shopAssistent.nextLine();
        }

        System.out.println("Изменить нижнюю границу? ");
        System.out.print("Введите число или любой знак, чтобы оставить текущее значение >> ");
        try {
            double n = shopAssistent.nextDouble();
            if (n <= numberRange[1] && n > numberRange[0]) {
                numberRange[0] = n;
            }
        } catch (Exception e) {
            shopAssistent.nextLine();
        }

        System.out.printf("Новый диапазон: %s - %s\n", numberRange[0], numberRange[1]);

        return numberRange;

    }

}

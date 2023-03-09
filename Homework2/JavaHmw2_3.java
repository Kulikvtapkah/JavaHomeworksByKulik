/*
Напишите метод, который принимает на вход строку (String) 
и определяет является ли строка палиндромом (возвращает boolean значение).
*/

package JavaHomeworksByKulik.Homework2;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class JavaHmw2_3 {
    public static void main(String[] args) throws IOException {
        Scanner strigScan = new Scanner(System.in);
        System.out.println("Введите строку, вдруг это палиндром >>");
        String stringToTest = strigScan.nextLine();

        if (isPalindrom(stringToTest)) {
            System.out.println("Ура! Это палиндром!");
        }
        else{
            System.out.println("Не палиндром, зато как красиво сказано...");
        }
    }

    public static boolean isPalindrom(String line) {
        boolean result = true;
        StringBuilder builtLine = new StringBuilder(line);
        int i = 0;
        while (i < builtLine.length() / 2 && result == true) {
            if (builtLine.charAt(i) == builtLine.charAt(builtLine.length() - i - 1)) {
                i++;
            } else {
                result = false;
            }
        }
        System.out.println(result);
        return result;
    }
}

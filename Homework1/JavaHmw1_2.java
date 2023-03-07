/*Вывести все простые числа от 1 до 1000 */

package JavaHomeworksByKulik.Homework1;

import java.util.Scanner;

public class JavaHmw1_2 {
    public static void main(String[] args) {

        System.out.println("Простые числа от 1 до 1000. Вуаля:");
        int currentNumber = 1;
        int printCount = 1;
        while (currentNumber <= 1000) {
            int divider = 2;
            boolean flag = false;
            while (divider < currentNumber && flag == false) {
                if (currentNumber % divider == 0)
                    flag = true;
                divider++;
            }
            if (flag == false) {
                System.out.printf("%s ", currentNumber);
                if (printCount % 10 == 0) {
                    System.out.print("\n");
                    printCount = 0;
                }
                printCount++;
            }
            currentNumber++;
        }
    }
}

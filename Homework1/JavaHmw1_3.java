/*Реализовать простой калькулятор (+ - / *)
Ввод числа ->
Ввод знака ->
Ввод числа -> */

package JavaHomeworksByKulik.Homework1;

import java.util.Scanner;
import java.io.IOException;

public class JavaHmw1_3 {
    public static void main(String[] args) throws IOException {
        char calc = 'y';
        System.out.println("Посчитаем!");
        while (calc != 'n') {
            float n1 = getNumber();
            char sign = getOperation();
            float n2 = getNumber();
            calculations(n1, n2, sign);
            calc = calcOnOff(calc);
        }
        System.out.println("Пока!");
    }

    public static float getNumber() {
        System.out.print("Введите число >> ");
        boolean test = false;
        float n = 0;

        while (test == false) {
            try {
                Scanner numInput = new Scanner(System.in);
                n = numInput.nextFloat();
                test = true;
                // numInput.close();
            } catch (Exception e) {
                System.out.print("Вести подсчеты в символах - такое себе...\n Все таки нужно число >> ");
            }
        }
        return n;
    }

    public static char getOperation() throws IOException {
        System.out.print("Введите знак (+; -; / или *) >> ");
        char s = '+';
        boolean test = false;
        while (test == false) {
            s = (char) System.in.read();
            if (s == '+' || s == '*' || s == '/' || s == '-') {
                test = true;
            } else
                System.out.print("Вряд ли это знак +; -; / или *\nПопробуйте снова >> ");
        }

        return s;
    }

    public static void calculations(float n1, float n2, char s) {
        float result = 0;
        switch (s) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n1 / n2;
                break;

        }
        System.out.printf(" %s %s %s = %s \n", n1, s, n2, result);

    }

    public static char calcOnOff(char calcState) throws IOException {
        System.out.print(
                "\nЕще посчитаем?\nВведите любой символ, чтобы продолжить, или \"n\", чтобы выключить калькулятор >> ");
        calcState = (char) System.in.read();
        return calcState;
    }
}

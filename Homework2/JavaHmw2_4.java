/*
К калькулятору из предыдущего дз добавить логирование
*/

package JavaHomeworksByKulik.Homework2;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class JavaHmw2_4 {
    public static void main(String[] args) throws IOException {
        Logger calcLogger = Logger.getLogger(JavaHmw2_4.class.getName());
        FileHandler calcHandler = new FileHandler("JavaHomeworksByKulik/calcLog.txt");
        calcLogger.addHandler(calcHandler);
        SimpleFormatter easyFormat = new SimpleFormatter();
        calcHandler.setFormatter(easyFormat);
        char calc = 'y';
        calcLogger.info("Calc is on");
        System.out.println("Посчитаем!");
        while (calc != 'n') {
            float n1 = getNumber();
            char sign = getOperation();
            float n2 = getNumber();
            calcLogger.info(calculations(n1, n2, sign));    
            calc = calcOnOff(calc);
            
        }
        System.out.println("Пока!");
        calcLogger.info("Calc is off");
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

    public static String calculations(float n1, float n2, char s) {
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
        return String.format(" %s %s %s = %s \n", n1, s, n2, result);


    }

    public static char calcOnOff(char calcState) throws IOException {
        System.out.print(
                "\nЕще посчитаем?\nВведите любой символ, чтобы продолжить, или \"n\", чтобы выключить калькулятор >> ");
        calcState = (char) System.in.read();
        return calcState;
    }
}

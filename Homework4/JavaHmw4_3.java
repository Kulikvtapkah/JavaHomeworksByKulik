/*
В калькулятор добавьте возможность отменить последнюю операцию.
*/

package JavaHomeworksByKulik.Homework4;

import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class JavaHmw4_3 {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        Logger calcLogger = Logger.getLogger(JavaHmw4_3.class.getName());
        FileHandler calcHandler = new FileHandler("JavaHomeworksByKulik/calcLog.txt");
        calcLogger.addHandler(calcHandler);
        SimpleFormatter easyFormat = new SimpleFormatter();
        calcHandler.setFormatter(easyFormat);
        String calcState = "on";
        calcLogger.info("Calc is on");
        float n1;
        Stack<Float> history = new Stack<Float>();

        System.out.println("Посчитаем!");
        while (!calcState.equals("off")) {
            if (history.isEmpty() || calcState.equals("0")) {
                n1 = getNumber(scan);
            } else {
                n1 = history.lastElement();
                System.out.printf("\nТекущий результат >> %s\n", n1);
            }

            char sign = getOperation(scan);
            float n2 = getNumber(scan);
            history.push(calculations(n1, n2, sign));
            calcLogger.info(String.format(" %s %s %s = %s \n", n1, sign, n2, history.lastElement()));

            System.out.print("Введите любой символ, чтобы продолжить с текущим результатом ");
            System.out.print("\nили \"0\": сброс; \"back\": откатить результат; \"clear\": очистить историю. ");
            System.out.print("\nВведите \"off\", чтобы выключить калькулятор >> ");

            calcState = scan.nextLine();
            calcState = scan.nextLine();

            while (calcState.equals("back") && !history.isEmpty()) {
                history.pop();
                if (history.isEmpty()) {
                    calcState.equals("0");
                } else {
                    System.out.printf("Текущий результат: %s.\n Принять? (или 0/clear/back/off)  >> ",
                            history.lastElement());
                    calcState = scan.next();
                }

            }

            if (calcState.equals("clear"))
                history.clear();

        }
        System.out.println("Пока!");
        calcLogger.info("Calc is off");
        scan.close();
    }

    public static float getNumber(Scanner scan) {

        boolean test = false;
        float n = 0;

        System.out.print("Введите число >> ");

        while (test == false) {
            if (scan.hasNextFloat()) {
                n = scan.nextFloat();
                test = true;
                ;
            } else {
                System.out.print("Вести подсчеты в символах - такое себе...\n Все таки нужно число >> ");
            }
        }
        return n;
    }

    public static char getOperation(Scanner scan) throws IOException {
        System.out.print("Введите знак (+; -; / или *) >> ");
        String s = "+";
        boolean test = false;
        while (test == false) {
            s = scan.next();
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                test = true;
            } else
                System.out.print("Вряд ли это знак +; -; / или *\nПопробуйте снова >> ");
        }
        return s.charAt(0);
    }

    public static float calculations(float n1, float n2, char s) {
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
        return result;

    }

}

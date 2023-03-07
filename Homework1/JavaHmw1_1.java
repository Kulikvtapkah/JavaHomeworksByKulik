/*Вычислить n-ое треугольноe число(сумма чисел от 1 до n), 
а так же n! (произведение чисел от 1 до n)
Ввод:5
Треугольное число 1 + 2 + 3 + 4 + 5 = 15
n! 1 * 2 * 3 * 4 * 5 = 120 */

package JavaHomeworksByKulik.Homework1;

import java.util.Scanner;

public class JavaHmw1_1 {
    public static void main(String[] args) {

        System.out.println("Нужно треугольное число и факториал числа n. Поехали!");
        int n = getN();

        int triangleN = 0;
        int factorialN = 1;

        while (n > 0) {
            triangleN += n;
            factorialN *= n;
            n--;
        }

        System.out.printf("n! = %s \n", factorialN);
        if (triangleN == 0) {
            System.out.println("А вот треугольник из ничего  не получится(");
        } else {
            System.out.printf("Tn = %s ", triangleN);
        }

    }

    public static int getN() {
        System.out.print("Введите целое неотрицательное n >> ");
        int n = -1;
        while (n < 0) {
            try {
                Scanner nInput = new Scanner(System.in);
                n = nInput.nextInt();
                if (n < 0) {
                    System.out.print("На отрицательных числах магия не работает( \n Попробуйте снова >> ");
                } else
                    nInput.close();
            } catch (Exception e) {
                System.out.print("Для начала хотя бы число... по возможности целое, неотрицательное, пожалуйста >> ");
            }
        }
        System.out.println("Ура, победа!");
        return n;
    }
}

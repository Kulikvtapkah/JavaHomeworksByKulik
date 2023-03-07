/*(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, 
например 2? + ?5 = 69 (пользователь).
Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет.
Ввод: 2? + ?5 = 69
Вывод: 24 + 45 = 69 */

package JavaHomeworksByKulik.Homework1;

import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class JavaHmw1_4 {
    public static void main(String[] args) throws IOException {
        System.out.print("Ууу! Люблю головоломки! Загадывай >> ");

        String riddle = getExpression();
        int plusPos = riddle.indexOf('+');
        int isPos = riddle.indexOf('=');

        int[] riddleArray = riddleDigitArray(riddle);
        int[] questionPose = getQuestionPose(riddle, riddleArray[riddle.length()]);

        String solution = "Не удалось найти решение(((";

        boolean test = false;
        int questionCount = questionPose.length;
        int n = 0;
        while (test == false && n < Math.pow(10, questionCount)) {
            int digit = n;
            for (int i = 0; i < questionCount; i++) {
                riddleArray[questionPose[i]] = digit % 10;
                digit /= 10;
            }
            n++;
            int w = getNumber(riddleArray, plusPos + 1, isPos);
            int q = getNumber(riddleArray, 0, plusPos);
            int e = getNumber(riddleArray, isPos + 1, riddleArray.length - 1);
            test = q + w == e;
            if (test) {
                solution = solution.format("Ура! Есть решение: %s + %s = %s!", q, w, e);
            }
        }
        System.out.println(solution);
    }

    public static String getExpression() {
        Scanner riddleInput = new Scanner(System.in);
        String riddle = riddleInput.nextLine();
        riddleInput.close();
        //String riddle = "1?3 + 3? = 166";
        riddle = riddle.replaceAll(" ", "");

        return riddle;
    }

    public static int[] riddleDigitArray(String riddle) {
        int[] riddleArray = new int[riddle.length() + 1];
        int questionCounter = 0;
        for (int i = 0; i < riddle.length(); i++) {
            if (riddle.charAt(i) == '?') {
                riddleArray[i] = 0;
                questionCounter++;
            } else {
                riddleArray[i] = Character.digit(riddle.charAt(i), 10);
            }
        }
        riddleArray[riddle.length()] = questionCounter;
        return riddleArray;
    }

    public static int[] getQuestionPose(String riddle, int questionCounter) {
        int[] questionPose = new int[questionCounter];
        questionCounter = 0;
        for (int i = 0; i < riddle.length(); i++) {
            if (riddle.charAt(i) == '?') {
                questionPose[questionCounter] = i;
                questionCounter++;
            }

        }
        return questionPose;
    }

    public static int getNumber(int[] riddleArray, int startPose, int stopPose) {
        int i = startPose;
        int n = 0;
        while (i < stopPose) {
            n = n * 10 + riddleArray[i];
            i++;
        }
        return n;
    }

}

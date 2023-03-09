/*Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации (после перемещения числа) запишите в лог-файл. */

package JavaHomeworksByKulik.Homework2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JavaHmw2_1 {
    public static void main(String[] args) throws IOException {

        Logger bubleLogger = Logger.getLogger(JavaHmw2_1.class.getName());
        FileHandler bulHandler = new FileHandler("JavaHomeworksByKulik/bubleLog.txt");
        bubleLogger.addHandler(bulHandler);
        SimpleFormatter easyFormat = new SimpleFormatter();
        bulHandler.setFormatter(easyFormat);
    
        int[] initialArray = {500, 8, 18, 3, 55, 90, 0, -200, -15, 66, -1000 };
        int n = 0;
        for (int i = 0; i < initialArray.length - 1; i++) {
            for (int j = 0; j < initialArray.length-i-1; j++) {
                if (initialArray[j + 1] < initialArray[j]) {
                    n = initialArray[j + 1];
                    initialArray[j + 1] = initialArray[j];
                    initialArray[j] = n;
                    bubleLogger.info(Arrays.toString(initialArray));
                }
            }
        }

    }

}

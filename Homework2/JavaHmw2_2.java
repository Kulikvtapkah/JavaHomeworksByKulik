/*Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */

package JavaHomeworksByKulik.Homework2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaHmw2_2 {
    public static void main(String[] args) throws IOException {
        Path docPath = Paths.get("JavaHomeworksByKulik/Homework2/ddd.txt").toAbsolutePath();
        System.out.println(docPath);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(docPath.toString()), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineRebuilder(line));
            }
        } catch (IOException e) {
            System.out.println("Не получилось. не фортануло(");
        }
    }

    public static StringBuilder lineRebuilder(String line) {
        StringBuilder builtLine = new StringBuilder(line);

        String[] replacement = {" по предмету ", " получил ", "Студент "};

        for (int i = 0; i < builtLine.length(); i++) {
            if (builtLine.charAt(i) == '"') {
                builtLine.deleteCharAt(i);
            }
        }

        int startPose = 0;
        int endPose = 0;
        int k = 0;

        for (int i = builtLine.length() - 1; i >= 0; i--) {
            if (builtLine.charAt(i) == ':') {
                endPose = i + 1;
            }
            if (builtLine.charAt(i) == ',' || i == 0) {
                startPose = i;
                builtLine.replace(startPose, endPose, replacement[k]);
                k++;
            }
        }
        return builtLine;
    }
}
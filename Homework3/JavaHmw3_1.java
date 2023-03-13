/*Пусть дан произвольный список целых чисел, удалить из него чётные числа */

package JavaHomeworksByKulik.Homework3;

import java.util.ArrayList;

public class JavaHmw3_1 {
    public static void main(String[] args) {
        ArrayList<Integer> randomList = getRandomList();

        System.out.print("Четные долой! ");
        randomList.removeIf(n -> (n % 2 == 0));
        System.out.print(randomList);
    }
    public static ArrayList<Integer> getRandomList() {
        ArrayList<Integer> randomList = new ArrayList<Integer>();
        for (int i = 0; i < 15; i++) {
            randomList.add((int)(Math.random()*200 - 100));
        }
        System.out.println(randomList);
        return randomList;
    }
}

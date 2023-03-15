/* Пусть дан LinkedList с несколькими элементами. 
Реализуйте метод(не void), который вернет “перевернутый” список. */

package JavaHomeworksByKulik.Homework4;

import java.util.LinkedList;

public class JavaHmw4_1 {
    public static void main(String[] args) {
        LinkedList<Integer> randomList = getRandomList(15);
        System.out.printf("Реверс:\n %s", listReverse(randomList));
    }

    public static LinkedList<Integer> getRandomList(int size) {
        LinkedList<Integer> randomList = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
            randomList.add((int) (Math.random() * 200 - 100));
        }
        System.out.printf("Случайный массив на %s элементов:\n %s\n", size, randomList);
        return randomList;
    }

    public static LinkedList<Integer> listReverse(LinkedList<Integer> listToReverse) {

        for (int i = listToReverse.size() - 2; i >= 0; i--) {
            listToReverse.add(listToReverse.remove(i));
        }
        return listToReverse;
    }

}

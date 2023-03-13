/*Задан целочисленный список ArrayList. 
Найти минимальное, максимальное и среднее ариф. из этого списка */

package JavaHomeworksByKulik.Homework3;
import java.util.ArrayList;
import java.util.Collections;


public class JavaHmw3_2 {
    public static void main(String[] args) {
        ArrayList<Integer> randomList = getRandomList(15);
  
        System.out.printf("Max = %s\n", Collections.max(randomList));
        System.out.printf("Min = %s\n", Collections.min(randomList));

        float average = 0;
        for (int el : randomList)  average += el;
        average /= randomList.size();
        System.out.printf("Average = %s", average);
        
    }
    public static ArrayList<Integer> getRandomList(int size) {
        ArrayList<Integer> randomList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            randomList.add((int)(Math.random()*200 - 100));
        }
        System.out.println(randomList);
        return randomList;
    }

}

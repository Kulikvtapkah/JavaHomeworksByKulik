/* Реализовать алгоритм сортировки слиянием */

package JavaHomeworksByKulik.Homework3;
import java.util.LinkedList;


public class JavaHmw3_3 {
    public static void main(String[] args) {
        LinkedList<Integer> randomList = getRandomList(15);
        System.out.printf("После сортировки слиянием: %s", mergeSort(randomList));
    }

    public static LinkedList<Integer> getRandomList(int size) {
        LinkedList<Integer> randomList = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
            randomList.add((int) (Math.random() * 200 - 100));
        }
        System.out.printf("Случайный массив на %s элементов: %s\n", size, randomList);
        return randomList;
    }

    public static LinkedList <Integer> mergeSort (LinkedList <Integer> listToSort) {

        int stepSize = 1;

        while (stepSize  < listToSort.size()){
            int startPose = 0;
            int left = startPose;
            int right  = left + stepSize;
            if (right > listToSort.size() - 1){
                right = listToSort.size();
            }
            
            while( left  < listToSort.size() ){
                int i = 0;
                while (right < startPose + stepSize * 2 && right < listToSort.size() && i < stepSize) {
                    if (listToSort.get(left) < listToSort.get(right)){
                        left++;
                        i++;
                    }
                    else{
                        listToSort.add(left, listToSort.remove(right));
                        right++;
                        i--;
                    }
                }
                startPose += stepSize * 2;
                left = startPose;
                right  = left + stepSize;
                if (right > listToSort.size() - 1) {
                    right = listToSort.size();
                }
            }
            stepSize *= 2;
        }
        return listToSort;
    }

}

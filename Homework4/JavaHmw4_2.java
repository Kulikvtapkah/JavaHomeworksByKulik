/* Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя. */

package JavaHomeworksByKulik.Homework4;

import java.util.LinkedList;

public class JavaHmw4_2 {
    public static void main(String[] args) {

        SimpleQueue q = new SimpleQueue();

        q.enqueue(177);
        for (int i = 0; i < 10; i++) {
            q.enqueue((int) (Math.random() * 100 - 50));
        }
        System.out.printf("Очередь из нескольких элементов: %s\n", q.queue);
        System.out.printf("\nУдалим %s, будет: %s", q.dequeue(), q.queue);
        System.out.printf("\nУдалим еще два, их сумма: %s, будет: %s", q.dequeue() + q.dequeue(), q.queue);
        System.out.printf("\nПервый элемет сейчас: %s", q.first());

        System.out.println("\nЕсли удалять или использовать элементы, когда их нет:");
        for (int i = 0; i < 9; i++)
            q.dequeue();
        System.out.println(q.queue);
        System.out.printf("Первый элемет сейчас: %s\n", q.first());

        q.enqueue(177);
        q.enqueue(822);
        System.out.println(q.queue);

    }
}

/**
 * Quelik
 */
class SimpleQueue {
    LinkedList<Integer> queue = new LinkedList<Integer>();

    void enqueue(int newItem) {
        queue.add(newItem);
    }

    int dequeue() {
        if (!queue.isEmpty())
            return queue.removeFirst();
        else {
            System.out.println("Очередь уже пуста =(");
            return 404; // не поняла, как вернуть null или что-то типа того.
                        // Решила, что 404 в самый раз для ошибки, хотя и не уверена, стоило ли так
                        // делать
        }
    }

    int first() {
        if (!queue.isEmpty())
            return queue.getFirst();
        else {
            System.out.println("Очередь пуста =(");
            return 404;
        }

    }

}
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int numberElements = Integer.parseInt(sc.nextLine());

        Deque<Integer> deque = new ArrayDeque<>(numberElements);
        for (int i = 0; i < numberElements; i++) {
            int nextElem = Integer.parseInt(sc.nextLine());
            if (nextElem % 2 == 0) {
                deque.addFirst(nextElem);
            } else {
                deque.addLast(nextElem);
            }
        }

        deque.forEach(System.out::println);
        sc.close();
    }
}
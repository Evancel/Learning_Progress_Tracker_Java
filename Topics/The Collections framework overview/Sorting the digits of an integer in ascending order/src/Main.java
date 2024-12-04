import java.lang.Integer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        List<Integer> list = convertToList(number);
        System.out.println(list);
    }

    public static List<Integer> convertToList(int number) {
        String srcNumber = String.valueOf(number);
        List<Integer> elem = new ArrayList<>();
        for (int i = 0; i < srcNumber.length(); i++) {
            elem.add(Integer.parseInt(srcNumber.substring(i, i + 1)));
        }
        elem.sort(Integer::compareTo);
        return elem;
    }
}
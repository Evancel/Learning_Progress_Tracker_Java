import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int numberElements = Integer.parseInt(sc.nextLine());
        Set<String> setStrings = new TreeSet<>();
        for(int i = 0; i < numberElements; i++){
            setStrings.add(sc.nextLine());
        }
        setStrings.forEach(System.out :: println);
        sc.close();
    }
}
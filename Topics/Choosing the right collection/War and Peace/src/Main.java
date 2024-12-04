import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Map<String, Integer> dictionary = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().toLowerCase().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            int counter = 0;
            if (dictionary.containsKey(words[i])) {
                counter = dictionary.get(words[i]);
            }
            dictionary.put(words[i], ++counter);
        }

        //print
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        sc.close();
    }
}
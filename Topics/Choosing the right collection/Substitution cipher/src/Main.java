import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        Map<Character, Character> dictionary = new HashMap<>();

        char[] sourceWord = sc.nextLine().toCharArray();
        char[] cipherWord = sc.nextLine().toCharArray();

        char[] wordForEncrypt = sc.nextLine().toCharArray();
        char[] wordForDecrypt = sc.nextLine().toCharArray();

        if (sourceWord.length != cipherWord.length) {
            System.out.println("Length are different. The task is impossible!");
            return;
        }

        for (int i = 0; i < sourceWord.length; i++) {
            dictionary.put(sourceWord[i], cipherWord[i]);
        }

        char[] encryptedWord = new char[wordForEncrypt.length];
        for (int i = 0; i < wordForEncrypt.length; i++) {
            encryptedWord[i] = dictionary.get(wordForEncrypt[i]);
        }

        String enWord = String.copyValueOf(encryptedWord);

        char[] decryptedWord = new char[wordForDecrypt.length];
        for (int i = 0; i < wordForDecrypt.length; i++) {
            for (Map.Entry<Character, Character> entry : dictionary.entrySet()) {
                if (entry.getValue() == wordForDecrypt[i]) {
                    decryptedWord[i] = entry.getKey();
                }
            }
        }

        String deWord = String.copyValueOf(decryptedWord);

        System.out.println(enWord);
        System.out.println(deWord);

        sc.close();
    }
}
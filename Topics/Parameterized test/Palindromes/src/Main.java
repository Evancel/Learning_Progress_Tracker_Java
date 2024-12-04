import java.util.Scanner;

class StringUtils {
//class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println(isPalindrome(sc.nextLine()));
//        sc.close();
//    }
    public static boolean isPalindrome(String str) {
        // your code here
        if(str == null || str.isBlank()){
            return false;
        }

        str = str.replaceAll("[',\\s+]","").toLowerCase();

        int start = 0;
        int end = str.length() - 1;

        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return  false;
            }
            ++start;
            --end;
        }
        return true;
    }
}
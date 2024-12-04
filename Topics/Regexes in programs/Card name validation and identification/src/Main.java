import java.util.*;

class BankCard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String numbers = scn.nextLine();
        String card = numbers.replaceAll("\\s", "");
        String visaRegex = "^4[0-9]{3}\\s*([0-9]{4}\\s*){3}$";
        String masterCardRegex = "(^5[1-5][0-9]{2}\\s*([0-9]{4}\\s*){3}$)|(^2((2((2[1-9])|([3-9][0-9])))|([3-6][0-9]{2})|(7(([0-1][0-9])|20)))\\s*([0-9]{4}\\s*){3}$)";
//        String test = "^2((2((2[1-9])|([3-9][0-9])))|([3-6][0-9]{2})|(7(([0-1][0-9])|20)))\\s*([0-9]{4}\\s*){3}$";
        String americanExpressRegex = "^3[4-7][0-9]{2}\\s*([0-9]{4}\\s*){2}[0-9]{3}\\s*$";

        if (card.matches(visaRegex)) {
            System.out.println("Visa");
        } else if (card.matches(masterCardRegex)) {
            System.out.println("MasterCard");
        } else if (card.matches(americanExpressRegex)) {
            System.out.println("AmericanExpress");
        } else {
            System.out.println("Card number does not exist");
        }
    }
}
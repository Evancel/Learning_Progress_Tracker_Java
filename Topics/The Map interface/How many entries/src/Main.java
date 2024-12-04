import java.util.*;

class Main {
    private static void log(Map<Long, String> map) {
        // implement me
        switch (map.size()) {
            case 1:
                System.out.println("Something in the map");
                break;
            case 0:
                System.out.println("There are no objects");
                break;
            default:
                System.out.println("Too many objects");
                break;
        }
    }

    // do not change the code below
    public static void main(String[] args) {
        String valueBase = "value-";
        Scanner scanner = new Scanner(System.in);

        Map<Long, String> m = new HashMap<>();
        long size = scanner.nextLong();
        for (long i = 0; i < size; ++i) {
            Long key = i;
            String value = valueBase + i;
            m.put(key, value);
        }
        log(Map.copyOf(m));
    }
}
import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        // write your code here
        int counter = 0;
        for(Map.Entry<String, String> entry : map1.entrySet()){
            if(map2.containsKey(entry.getKey()) && map2.get(entry.getKey()).equals(entry.getValue())){
                ++counter;
            }
        }
        System.out.println(counter);
    }
}
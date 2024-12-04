import java.util.*;

class ListOperations {
    public static void removeTheSame(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        // write your code here
        if (linkedList == null || arrayList == null) {
            throw new IllegalArgumentException("Input lists cannot be null");
        }

        // Ensure both lists are the same size for safe index-based traversal
        int minSize = Math.min(linkedList.size(), arrayList.size());

        for(int i = minSize - 1; i >= 0; i--){
            if(linkedList.get(i).equals(arrayList.get(i))){
                linkedList.remove(i);
                arrayList.remove(i);
            }
        }
    }
}
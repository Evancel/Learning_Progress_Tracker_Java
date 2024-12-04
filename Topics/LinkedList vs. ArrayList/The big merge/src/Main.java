import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class ListOperations {
    public static void mergeLists(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        // write your code here
        if(arrayList == null){
            return;
        }
        linkedList.addAll(arrayList);
        System.out.printf("The new size of LinkedList is %d\n",linkedList.size());
        HashMap

    }
}
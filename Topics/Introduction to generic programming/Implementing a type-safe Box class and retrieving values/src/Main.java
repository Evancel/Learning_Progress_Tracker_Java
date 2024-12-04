import java.util.*;

public class Main {
    static class Box<T> {
        // your code here
        private T t;
        public Box(T t){
            this.t = t;
        }

        public T get(){
            return this.t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextInt()) {
            int num = sc.nextInt();
            Box<Integer> boxNum = new Box<>(num);
            System.out.println(boxNum.get());
        } else if (sc.hasNextFloat()) {
            float num = sc.nextFloat();
            Box<Float> boxFloat = new Box<>(num);
            System.out.println(boxFloat.get());
        } else {
            String str = sc.next();
            Box<String> boxString = new Box<>(str);
            System.out.println(boxString.get());
        }
    }
}
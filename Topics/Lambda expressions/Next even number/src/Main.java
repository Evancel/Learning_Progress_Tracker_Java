import java.util.function.LongUnaryOperator;

class Operator {

    public static LongUnaryOperator unaryOperator = (x) -> {
        do{
            x++;
        }while(x % 2 != 0);
        return x;
    };
}
/*
class Main{
    public static void main(String[] args) {
        long num = Operator.unaryOperator.applyAsLong(317);
        System.out.println(num);
    }
}

 */
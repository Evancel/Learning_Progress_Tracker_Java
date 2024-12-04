import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Utils {

    public static void sortUsers(List<User> users) {
        // your code here
        users.sort(Comparator.comparing(User::getName)
                .thenComparing(Comparator.comparing(User::getAge)
                        .reversed()));
    }
}
/*
class Main{
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John",25));
        users.add(new User("Jane",25));
        users.add(new User("Jim",18));
        users.add(new User("Jack",18));
        users.add(new User("John",30));
        Utils.sortUsers(users);
        for(User user : users){
            System.out.println(user);
        }
    }
}
 */
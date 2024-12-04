package tracker;

public class Student {
    private final int id;
    private String email;
    private String firstName;
    private String lastName;
    //java, dsa, db, spring
    private int[] points = new int[Course.values().length];
    private boolean[] notifications = new boolean[Course.values().length];

    public Student(){
        this.id = Students.counter;
    }

    public Student(String firstName, String lastName, String email){
        this.firstName  = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = Students.counter;
    }

    public int getId(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }

    public int[] getPoints(){
        return this.points;
    }

    public void addPoints(int[] points){
        for(int i = 0; i < points.length; i++){
            this.points[i] += points[i];
        }
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public boolean[] getNotifications(){
        return this.notifications;
    }

    public void setNotifications(boolean[] notifications){
        this.notifications = notifications;
    }

    public void setNotificationToFalse(int i){
        this.notifications[i] = false;
    }
}

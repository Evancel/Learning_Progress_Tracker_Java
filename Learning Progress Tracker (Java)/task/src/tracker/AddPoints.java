package tracker;

public class AddPoints {
    private int studentId;
    private int[] points;

    public AddPoints(){
    }

    public AddPoints(int studentId, int[] points){
        this.studentId = studentId;
        this.points = points;
    }

    public int[] getPoints(){
        return  points;
    }
}

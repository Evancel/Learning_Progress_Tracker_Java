package tracker;

import java.math.BigDecimal;

public class DetailCourseInformation {
    private int studentId;
    private int points;
    private BigDecimal completed;

    public DetailCourseInformation(){}
    public DetailCourseInformation(int studentId, int points, BigDecimal completed){
        this.studentId = studentId;
        this.points = points;
        this.completed = completed;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getPoints() {
        return points;
    }

    public BigDecimal getCompleted() {
        return completed;
    }
}

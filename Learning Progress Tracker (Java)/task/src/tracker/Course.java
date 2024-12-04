package tracker;

public enum Course {
    JAVA(0, "Java","javaPoints",600),
    DSA(1,"DSA","dsaPoints",400),
    DB(2,"Databases","dbPoints",480),
    SPRING(3,"Spring","springPoints",550);

    private int indexInArray;
    private String courseName;
    private String pointsName;
    private int maxPoints;

    Course(int indexInArray, String courseName, String pointsName, int maxPoints){
        this.indexInArray = indexInArray;
        this.courseName = courseName;
        this.pointsName = pointsName;
        this.maxPoints = maxPoints;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxPoints(){
        return this.maxPoints;
    }

    public int getIndexInArray() {
        return indexInArray;
    }

    public static int getMaxPointsByIndex(int index){
        int currentMaxPoints = 0;
        for(Course course : Course.values()){
            if(course.getIndexInArray() == index){
                currentMaxPoints = course.getMaxPoints();
            }
        }
        return  currentMaxPoints;
    }

    public static Course getCourseByIndex(int index){
        Course currentCourse = null;
        for(Course course : Course.values()){
            if(course.getIndexInArray() == index){
                currentCourse = course;
                break;
            }
        }
        return  currentCourse;
    }
}

package tracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Statistics {

private static int getMaxAmountStudents(int[] amountStudentsOnEachCourse) {
    int maxAmountStudents = 0;
    for (int i = 0; i < amountStudentsOnEachCourse.length; i++) {
        if (maxAmountStudents < amountStudentsOnEachCourse[i]) {
            maxAmountStudents = amountStudentsOnEachCourse[i];
        }
    }
    return maxAmountStudents;
}

private static int getMinAmountStudents(int[] amountStudentsOnEachCourse) {
    int minAmountStudents = Integer.MAX_VALUE;
    for (int i = 0; i < amountStudentsOnEachCourse.length; i++) {
        if (minAmountStudents > amountStudentsOnEachCourse[i]) {
            minAmountStudents = amountStudentsOnEachCourse[i];
        }
    }
    return minAmountStudents;
}

private static int getMaxAmountAssignments(int[] amountAssignmentsOnEachCourse) {
    int maxAssignments = 0;
    for (int i = 0; i < amountAssignmentsOnEachCourse.length; i++) {
        if (maxAssignments < amountAssignmentsOnEachCourse[i]) {
            maxAssignments = amountAssignmentsOnEachCourse[i];
        }
    }
    return maxAssignments;
}

private static int getMinAmountAssignments(int[] amountAssignmentsOnEachCourse) {
    int minAssignments = Integer.MAX_VALUE;
    for (int i = 0; i < amountAssignmentsOnEachCourse.length; i++) {
        if (minAssignments > amountAssignmentsOnEachCourse[i]) {
            minAssignments = amountAssignmentsOnEachCourse[i];
        }
    }
    return minAssignments;
}

private static double getMinLevelOfDifficulty(int[] amountAssignmentsOnEachCourse,int[] amountPointsOnEachCourse) {
    double minAVGPoints = Double.MAX_VALUE;
    for (int i = 0; i < amountPointsOnEachCourse.length; i++) {
        if (amountAssignmentsOnEachCourse[i] == 0) {
            continue;
        }

        if (minAVGPoints > (double) amountPointsOnEachCourse[i] / amountAssignmentsOnEachCourse[i]) {
            minAVGPoints = (double) amountPointsOnEachCourse[i] / amountAssignmentsOnEachCourse[i];
        }
    }
    return minAVGPoints;
}

private static double getMaxLevelOfDifficulty(int[] amountAssignmentsOnEachCourse,int[] amountPointsOnEachCourse) {
    double maxAVGPoints = 0;
    for (int i = 0; i < amountPointsOnEachCourse.length; i++) {
        if (amountAssignmentsOnEachCourse[i] == 0) {
            continue;
        }

        if (maxAVGPoints < (double) amountPointsOnEachCourse[i] / amountAssignmentsOnEachCourse[i]) {
            maxAVGPoints = (double) amountPointsOnEachCourse[i] / amountAssignmentsOnEachCourse[i];
        }
    }
    return maxAVGPoints;
}

//The most popular has the biggest number of enrolled students;
public static Collection<String> theMostPopularCourse(Students studentsMap) {
    //JAVA, DSA, DB, SPRING
    int[] amountStudentsOnEachCourse = new int[Course.values().length];

    for (Student student : studentsMap.getAllStudents()) {
        for (int i = 0; i < amountStudentsOnEachCourse.length; i++) {
            amountStudentsOnEachCourse[i] += student.getPoints()[i] == 0 ? 0 : 1;
        }
    }

    String courseName = null;
    List<String> theMostPopularCourses = new ArrayList<>();

    int maxAmountStudents = getMaxAmountStudents(amountStudentsOnEachCourse);
//    int minAmountStudents = getMinAmountStudents(amountStudentsOnEachCourse);
//    if (maxAmountStudents == minAmountStudents) {
//        theMostPopularCourses.add("n/a");
//        return theMostPopularCourses;
//    }

    for (int i = 0; i < amountStudentsOnEachCourse.length; i++) {
        if (amountStudentsOnEachCourse[i] == maxAmountStudents) {
            courseName = switch (i) {
                case 0 -> Course.JAVA.getCourseName();
                case 1 -> Course.DSA.getCourseName();
                case 2 -> Course.DB.getCourseName();
                case 3 -> Course.SPRING.getCourseName();
                default -> "unknown course";
            };
            theMostPopularCourses.add(courseName);
        }
    }

    if (courseName == null) {
        theMostPopularCourses.add("n/a");
        return theMostPopularCourses;
    }

    return theMostPopularCourses;
}

public static Collection<String> theLeastPopularCourse(Students studentsMap) {
    //JAVA, DSA, DB, SPRING
    int[] amountStudentsOnEachCourse = new int[Course.values().length];

    for (Student student : studentsMap.getAllStudents()) {
        for (int i = 0; i < amountStudentsOnEachCourse.length; i++) {
            amountStudentsOnEachCourse[i] += student.getPoints()[i] == 0 ? 0 : 1;
        }
    }

    String courseName = null;
    List<String> theLeastPopularCourses = new ArrayList<>();
    int maxAmountStudents = getMaxAmountStudents(amountStudentsOnEachCourse);
    int minAmountStudents = getMinAmountStudents(amountStudentsOnEachCourse);
    if (maxAmountStudents == minAmountStudents) {
        theLeastPopularCourses.add("n/a");
        return theLeastPopularCourses;
    }

    for (int i = 0; i < amountStudentsOnEachCourse.length; i++) {
        if (amountStudentsOnEachCourse[i] == minAmountStudents) {
            courseName = switch (i) {
                case 0 -> Course.JAVA.getCourseName();
                case 1 -> Course.DSA.getCourseName();
                case 2 -> Course.DB.getCourseName();
                case 3 -> Course.SPRING.getCourseName();
                default -> "unknown course";
            };
            theLeastPopularCourses.add(courseName);
        }
    }

    if (courseName == null) {
        theLeastPopularCourses.add("n/a");
    }

    return theLeastPopularCourses;
}

//Higher student activity means a bigger number of completed tasks;
public static Collection<String> theHighestActivityCourse(List<AddPoints> addPointsHistory) {
    //JAVA, DSA, DB, SPRING
    int[] amountAssignmentsOnEachCourse = new int[Course.values().length];

    for (AddPoints addPoints : addPointsHistory) {
        for (int i = 0; i < amountAssignmentsOnEachCourse.length; i++) {
            amountAssignmentsOnEachCourse[i] += addPoints.getPoints()[i] == 0 ? 0 : 1;
        }
    }

    int maxAmountAssignments = getMaxAmountAssignments(amountAssignmentsOnEachCourse);
//    int minAmountAssignments = getMinAmountAssignments(amountAssignmentsOnEachCourse);

    String courseName = null;
    List<String> theHighestActivityCourses = new ArrayList<>();
//    if(maxAmountAssignments == minAmountAssignments){
//        theHighestActivityCourses.add("n/a");
//        return theHighestActivityCourses;
//    }

    for (int i = 0; i < amountAssignmentsOnEachCourse.length; i++) {
        if (amountAssignmentsOnEachCourse[i] == maxAmountAssignments) {
            courseName = switch (i) {
                case 0 -> Course.JAVA.getCourseName();
                case 1 -> Course.DSA.getCourseName();
                case 2 -> Course.DB.getCourseName();
                case 3 -> Course.SPRING.getCourseName();
                default -> "unknown course";
            };
            theHighestActivityCourses.add(courseName);
        }
    }

    if (courseName == null) {
        theHighestActivityCourses.add("n/a");
    }

    return theHighestActivityCourses;
}

public static Collection<String> theLowestActivityCourse(List<AddPoints> addPointsHistory) {
    //JAVA, DSA, DB, SPRING
    int[] amountAssignmentsOnEachCourse = new int[Course.values().length];

    for (AddPoints addPoints : addPointsHistory) {
        for (int i = 0; i < amountAssignmentsOnEachCourse.length; i++) {
            amountAssignmentsOnEachCourse[i] += addPoints.getPoints()[i] == 0 ? 0 : 1;
        }
    }

    int minAmountAssignments = getMinAmountAssignments(amountAssignmentsOnEachCourse);
    int maxAmountAssignments = getMaxAmountAssignments(amountAssignmentsOnEachCourse);
    String courseName = null;
    List<String> theLowestActivityCourses = new ArrayList<>();
    if(maxAmountAssignments == minAmountAssignments){
        theLowestActivityCourses.add("n/a");
        return theLowestActivityCourses;
    }

    for (int i = 0; i < amountAssignmentsOnEachCourse.length; i++) {
        if (amountAssignmentsOnEachCourse[i] == minAmountAssignments) {
            courseName = switch (i) {
                case 0 -> Course.JAVA.getCourseName();
                case 1 -> Course.DSA.getCourseName();
                case 2 -> Course.DB.getCourseName();
                case 3 -> Course.SPRING.getCourseName();
                default -> "unknown course";
            };
            theLowestActivityCourses.add(courseName);
        }
    }

    if (courseName == null) {
        theLowestActivityCourses.add("n/a");
    }

    return theLowestActivityCourses;
}

//The hardest course has the lowest average grade per assignment;
public static Collection<String> theHardestCourse(List<AddPoints> addPointsHistory) {
    int[] amountAssignmentsOnEachCourse = new int[Course.values().length];
    int[] amountPointsOnEachCourse = new int[Course.values().length];
    for (AddPoints points : addPointsHistory) {
        for (int i = 0; i < amountAssignmentsOnEachCourse.length; i++) {
            amountAssignmentsOnEachCourse[i] += points.getPoints()[i] == 0 ? 0 : 1;
            amountPointsOnEachCourse[i] += points.getPoints()[i];
        }
    }

    double minAVGPoints = getMinLevelOfDifficulty(amountAssignmentsOnEachCourse,amountPointsOnEachCourse);
//    double maxAVGPoints = getMaxLevelOfDifficulty(amountAssignmentsOnEachCourse,amountPointsOnEachCourse);
    String courseName;
    List<String> theHardestCourses = new ArrayList<>();
//    if(minAVGPoints == maxAVGPoints){
//        theHardestCourses.add("n/a");
//        return theHardestCourses;
//    }

    for (int i = 0; i < amountPointsOnEachCourse.length; i++) {
        if ((double) amountPointsOnEachCourse[i] / amountAssignmentsOnEachCourse[i] == minAVGPoints) {
            courseName = switch (i) {
                case 0 -> Course.JAVA.getCourseName();
                case 1 -> Course.DSA.getCourseName();
                case 2 -> Course.DB.getCourseName();
                case 3 -> Course.SPRING.getCourseName();
                default -> "unknown course";
            };
            theHardestCourses.add(courseName);
        }
    }

    return theHardestCourses;
}

public static Collection<String> theEasiestCourse(List<AddPoints> addPointsHistory) {
    int[] amountAssignmentsOnEachCourse = new int[Course.values().length];
    int[] amountPointsOnEachCourse = new int[Course.values().length];
    for (AddPoints points : addPointsHistory) {
        for (int i = 0; i < amountAssignmentsOnEachCourse.length; i++) {
            amountAssignmentsOnEachCourse[i] += points.getPoints()[i] == 0 ? 0 : 1;
            amountPointsOnEachCourse[i] += points.getPoints()[i];
        }
    }

    double maxAVGPoints = getMaxLevelOfDifficulty(amountAssignmentsOnEachCourse, amountPointsOnEachCourse);
    double minAVGPoints = getMinLevelOfDifficulty(amountAssignmentsOnEachCourse, amountPointsOnEachCourse);
    String courseName;
    List<String> theEasiestCourses = new ArrayList<>();
    if(minAVGPoints == maxAVGPoints){
        theEasiestCourses.add("n/a");
        return theEasiestCourses;
    }

    for (int i = 0; i < amountPointsOnEachCourse.length; i++) {
        if ((double) amountPointsOnEachCourse[i] / amountAssignmentsOnEachCourse[i] == maxAVGPoints) {
            courseName = switch (i) {
                case 0 -> Course.JAVA.getCourseName();
                case 1 -> Course.DSA.getCourseName();
                case 2 -> Course.DB.getCourseName();
                case 3 -> Course.SPRING.getCourseName();
                default -> "unknown course";
            };
            theEasiestCourses.add(courseName);
        }
    }
    return theEasiestCourses;
}
}

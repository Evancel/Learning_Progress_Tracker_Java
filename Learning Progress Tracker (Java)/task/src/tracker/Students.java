package tracker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Students {
    private final Map<Integer, Student> students = new TreeMap<>();
    static int counter = 1;
    private final UserInterface userInterface = new UserInterface();

    public void addStudent(Student student) {
        if (student == null) {
            userInterface.printInvalidStudentMessage();
            return;
        }

        if (!emailIsUnique(student.getEmail())) {
            userInterface.printDuplicateEmailMessage();
            return;
        }

        students.put(counter++, student);
        userInterface.printStudentAddedMessage();
    }

    public Student getStudentById(int id) {
        if (!isIdValid(id)) {
            userInterface.printNoStudentById(id);
            return null;
        }

        return students.get(id);
    }

    public int amountStudents() {
        return students.size();
    }

    public Collection<Integer> getAllStudentIds() {
        return students.keySet();
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public Collection<DetailCourseInformation> getDetailInfoAboutStudentOnCourse(Course couse) {
        List<DetailCourseInformation> studentsOnCourse = new ArrayList<>();
        for (Student student : students.values()){
            int studentPoints = student.getPoints()[couse.getIndexInArray()];
            if(studentPoints > 0){
                int scale = 3; // Number of decimal places

                BigDecimal completed = new BigDecimal(studentPoints)
                        .divide(new BigDecimal(couse.getMaxPoints()),scale, RoundingMode.HALF_UP)
                        .multiply(new BigDecimal(100));
                studentsOnCourse.add(new DetailCourseInformation(student.getId(),
                        studentPoints,
                        completed));
            }
        }

        studentsOnCourse.sort(Comparator.comparing(DetailCourseInformation::getPoints).reversed()
                .thenComparing(DetailCourseInformation::getStudentId));
            return studentsOnCourse;
    }

    private boolean emailIsUnique(String email) {
        for (Student student : students.values()) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean isIdValid(int id) {
        return students.containsKey(id);
    }
}

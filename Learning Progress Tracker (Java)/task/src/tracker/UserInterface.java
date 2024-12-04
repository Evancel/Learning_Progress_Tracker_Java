package tracker;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final String TITLE_MESSAGE = "Learning Progress Tracker";
    private final String EXIT_MESSAGE = "Bye!";
    private final String ADD_STUDENT_PROMPT = "Enter student credentials or 'back' to return";
    private final String STUDENT_ADDED_SUCCESS_MESSAGE = "The student has been added.";
    private final String ADD_POINT_PROMPT = "Enter an id and points or 'back' to return";
    private final String TOTAL_STUDENTS_ADDED_FORMAT = "Total %d students have been added.\n";
    private final String NO_STUDENTS_MESSAGE = "No students found";
    private final String NO_STUDENTS_BY_ID_FORMAT = "No student is found for id=%d\n";
    private final String NO_STUDENTS_STRING_FORMAT = "No student is found for id=%s\n";
    private final String POINTS_ADDED_MESSAGE = "Points updated";
    private final String ENTER_ID_MESSAGE = "Enter an id or 'back' to return";
    private final String STUDENT_POINTS_INFO_FORMAT = "%d points: Java=%d; DSA=%d; Databases=%d; Spring=%d\n";
    private final String NAME_COURSE_PROMPT = "Type the name of a course to see details or 'back' to quit";
    private final String NO_DATA_ABOUT_COURSE = " n/a";
    private final String MOST_POPULAR_COURSE_FORMAT = "Most popular:%s\n";
    private final String LEAST_POPULAR_COURSE_FORMAT = "Least popular:%s\n";
    private final String HIGHEST_ACTIVITY_COURSE_FORMAT = "Highest activity:%s\n";
    private final String LOWEST_ACTIVITY_COURSE_FORMAT = "Lowest activity:%s\n";
    private final String EASIEST_COURSE_FORMAT = "Easiest course:%s\n";
    private final String HARDEST_COURSE_FORMAT = "Hardest course:%s\n";
    private final String TITLE_FOR_DETAIL_COURSE = "id    points    completed";
    private final String RECEIVER_FORMAT_FOR_NOTIFICATION = "To: %s\n";
    private final String SUBJECT_FOR_NOTIFICATION = "Re: Your Learning Progress";
    private final String MESSAGE_FORMAT_FOR_NOTIFICATION = "Hello, %s %s! You have accomplished our %s course!\n";
    private final String TOTAL_COUNT_NOTIFICATIONS_FORMAT = "Total %d students have been notified.\n";
    private final String BACK_HINT = "Enter 'exit' to exit the program";
    private final String NO_INPUT_MESSAGE = "No input";
    private final String UNKNOWN_COMMAND_MESSAGE = "Unknown command!";
    private final String INVALID_CREDENTIALS_MESSAGE = "Incorrect credentials.";
    private final String INVALID_FIRST_NAME_MESSAGE = "Incorrect first name";
    private final String INVALID_LAST_NAME_MESSAGE = "Incorrect last name";
    private final String INVALID_EMAIL_MESSAGE = "Incorrect email";
    private final String DUPLICATE_EMAIL_MESSAGE = "This email is already taken.";
    private final String INVALID_STUDENT_MESSAGE = "NPE! Student wasn't created.";
    private final String INVALID_ADD_POINT_INPUT = "Incorrect points format";
    private final String UNKNOWN_COURSE_MESSAGE = "Unknown course.";

    private Scanner userInterfaceScanner = new Scanner(System.in);

    public String getUserInput(){
//        System.out.print("> ");
        return userInterfaceScanner.nextLine().replaceFirst("^\\s+","");
    }

    public Commands getUserCommand(String input){
        if(isUserInputBlank(input)){
            printNoInput();
            return null;
        }

        for(Commands command : Commands.values()){
            if(input.equalsIgnoreCase(command.getDescription())){
                return command;
            }
        }

        printUnknownCommand();
        return null;
    }

    public String[] getCredentials(String userInput){
        String[] credentials = userInput.split("\\s+");

        if(credentials.length < 3){
            printInvalidCredentialsMessage();
            return null;
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9]+$";
        String email = credentials[credentials.length - 1];
        if(!email.matches(emailRegex)){
            printInvalidEmailMessage();
            return null;
        }

        String firstName = credentials[0];
        String nameRegex = "^[A-Za-z]+([-']?[A-Za-z])+$";
        if(!firstName.matches(nameRegex)){
            printInvalidFirstNameMessage();
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < credentials.length - 1; i++){
            if(!credentials[i].matches(nameRegex)){
                printInvalidLastNameMessage();
                return null;
            }

            if(i != credentials.length - 2){
                sb.append(" ");
            }
            sb.append(credentials[i]);
        }
        String lastName = sb.toString();

        return new String[]{firstName,lastName,email};
    }

    public int[] getPoints(String userInput){
        if(!isGetPointsStringValid(userInput)){
            printInvalidAddPointInput();
            return null;
        }

        int[] points = new int[Course.values().length];
        for(int i = 0; i < points.length; i++) {
            points[i] = Integer.parseInt(userInput.split("\\s+")[i]);
            if(points[i] < 0){
                printInvalidAddPointInput();
                return null;
            }
        }
        return points;
    }

    private boolean isGetPointsStringValid(String userInput){
        return userInput.matches("^(\\d+\\s+){3}\\d+\\s*$");
    }

    public Student getStudent(String[] credentials){
        return new Student(credentials[0], credentials[1], credentials[2]);
    }

    private boolean isUserInputBlank(String input){
        return input.isBlank();
    }

    public void printTitle(){
        System.out.println(TITLE_MESSAGE);
    }

    public void printBye(){
        System.out.println(EXIT_MESSAGE);
    }

    public void printAddStudentPrompt(){
        System.out.println(ADD_STUDENT_PROMPT);
    }

    public void printAddPointPrompt(){
        System.out.println(ADD_POINT_PROMPT);
    }

    public void printStudentAddedMessage(){
        System.out.println(STUDENT_ADDED_SUCCESS_MESSAGE);
    }

    public void printEnterIdPrompt(){
        System.out.println(ENTER_ID_MESSAGE);
    }

    public void printInfoAboutStudentPoints(Student student){
        System.out.printf(STUDENT_POINTS_INFO_FORMAT,
                student.getId(),
                student.getPoints()[0],
                student.getPoints()[1],
                student.getPoints()[2],
                student.getPoints()[3]);
    }

    public void printTotalStudentAddedAmountString(int studentCount){
        System.out.printf(TOTAL_STUDENTS_ADDED_FORMAT, studentCount);
    }

    public void printAllStudentIds(Collection<Integer> studentIds){
        if(studentIds.isEmpty()){
            System.out.println(NO_STUDENTS_MESSAGE);
            return;
        }
        System.out.println("Students:");
        studentIds.forEach(System.out :: println);
    }

    public void printNameCoursePrompt(){
        System.out.println(NAME_COURSE_PROMPT);
    }

    public void printGeneralStatisticsNoData(){
        System.out.printf(MOST_POPULAR_COURSE_FORMAT, NO_DATA_ABOUT_COURSE);
        System.out.printf(LEAST_POPULAR_COURSE_FORMAT, NO_DATA_ABOUT_COURSE);
        System.out.printf(HIGHEST_ACTIVITY_COURSE_FORMAT, NO_DATA_ABOUT_COURSE);
        System.out.printf(LOWEST_ACTIVITY_COURSE_FORMAT, NO_DATA_ABOUT_COURSE);
        System.out.printf(EASIEST_COURSE_FORMAT, NO_DATA_ABOUT_COURSE);
        System.out.printf(HARDEST_COURSE_FORMAT,NO_DATA_ABOUT_COURSE);
    }

    public void printGeneralStatisticsAboutCourses(Collection<String> theMostPopularCourses,
                                                   Collection<String> theLeastPopularCourses,
                                                   Collection<String> theHighestActivityCourses,
                                                   Collection<String> theLowestActivityCourses,
                                                   Collection<String> theEasiestCourses,
                                                   Collection<String> theHardestCourses){
        System.out.printf(MOST_POPULAR_COURSE_FORMAT, coursesNamesForPrinting(theMostPopularCourses));
        System.out.printf(LEAST_POPULAR_COURSE_FORMAT, coursesNamesForPrinting(theLeastPopularCourses));
        System.out.printf(HIGHEST_ACTIVITY_COURSE_FORMAT, coursesNamesForPrinting(theHighestActivityCourses));
        System.out.printf(LOWEST_ACTIVITY_COURSE_FORMAT, coursesNamesForPrinting(theLowestActivityCourses));
        System.out.printf(EASIEST_COURSE_FORMAT, coursesNamesForPrinting(theEasiestCourses));
        System.out.printf(HARDEST_COURSE_FORMAT, coursesNamesForPrinting(theHardestCourses));

    }

    private String coursesNamesForPrinting(Collection<String> courses){
        StringBuilder coursesNames = new StringBuilder();
        for(String courseName:courses){
            coursesNames.append(" ").append(courseName).append(",");
        }
        String coursesForPrinting = coursesNames.toString().substring(0,Math.max(coursesNames.length()-1,0));
        return coursesForPrinting;
    }

    public void printDetailInformationAboutCourse(Course currCourse,List<DetailCourseInformation> informationAboutStudentsOnCourse){
        System.out.println(currCourse.getCourseName());
        System.out.println(TITLE_FOR_DETAIL_COURSE);
        for(DetailCourseInformation info: informationAboutStudentsOnCourse){
            System.out.printf("%d %d %.1f%%\n", info.getStudentId(),info.getPoints(),info.getCompleted());
        }
    }

    public void printEmailNotificationForStudent(Student student, Course course){
        System.out.printf(RECEIVER_FORMAT_FOR_NOTIFICATION,student.getEmail());
        System.out.println(SUBJECT_FOR_NOTIFICATION);
        System.out.printf(MESSAGE_FORMAT_FOR_NOTIFICATION,student.getFirstName(), student.getLastName(),course.getCourseName());
    }

    public void printTotalInformationAboutNotifications(int counterNotifications){
        System.out.printf(TOTAL_COUNT_NOTIFICATIONS_FORMAT,counterNotifications);
    }

    public void printNoStudentById(int id){
        System.out.printf(NO_STUDENTS_BY_ID_FORMAT, id);
    }

    public void printNoStudentById(String input){
        System.out.printf(NO_STUDENTS_STRING_FORMAT, input);
    }

    public void printPointsAdded(){
        System.out.println(POINTS_ADDED_MESSAGE);
    }

    public void printBackHint(){
        System.out.println(BACK_HINT);
    }

    public void printNoInput(){
        System.out.println(NO_INPUT_MESSAGE);
    }

    public void printUnknownCommand(){
        System.out.println(UNKNOWN_COMMAND_MESSAGE);
    }

    public void printInvalidCredentialsMessage(){
        System.out.println(INVALID_CREDENTIALS_MESSAGE);
    }

    public void printInvalidFirstNameMessage(){
        System.out.println(INVALID_FIRST_NAME_MESSAGE);
    }

    public void printInvalidLastNameMessage(){
        System.out.println(INVALID_LAST_NAME_MESSAGE);
    }

    public void printInvalidEmailMessage(){
        System.out.println(INVALID_EMAIL_MESSAGE);
    }

    public void printDuplicateEmailMessage(){
        System.out.println(DUPLICATE_EMAIL_MESSAGE);
    }

    public void printInvalidStudentMessage(){
        System.out.println(INVALID_STUDENT_MESSAGE);
    }

    public void printInvalidAddPointInput(){
        System.out.println(INVALID_ADD_POINT_INPUT);
    }

    public void printUnknownCourse(){
        System.out.println(UNKNOWN_COURSE_MESSAGE);
    }
}

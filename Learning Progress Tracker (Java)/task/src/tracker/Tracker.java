package tracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tracker {

    private final UserInterface userInterface = new UserInterface();
    private final Students studentsMap = new Students();
    private final List<AddPoints> addPointsHistory = new ArrayList<>();
    Commands currCommand;

    public Tracker() {
    }

    public void work() {
        start();
        do {
            getInput();
        } while (currCommand != Commands.EXIT);
    }

    public void start() {
        userInterface.printTitle();
    }

    public void getInput() {
        String userInput = userInterface.getUserInput();
        currCommand = userInterface.getUserCommand(userInput);
        if (currCommand == null) {
            return;
        }
        switch (currCommand) {
            case EXIT -> userInterface.printBye();
            case ADD -> addStudentProcess();
            case LIST -> printAllStudentIds();
            case ADD_POINTS -> addPointProcess();
            case FIND -> findStudentProcess();
            case STATISTICS -> printStatistics();
            case NOTIFY -> notifyStudentsProcess();
            case BACK -> userInterface.printBackHint();
        }
    }

    private void addStudentProcess() {
        userInterface.printAddStudentPrompt();
        do {
            String userInput = userInterface.getUserInput();
            if (userInput.equalsIgnoreCase(Commands.BACK.getDescription())) {
                currCommand = Commands.BACK;
                userInterface.printTotalStudentAddedAmountString(studentsMap.amountStudents());
                return;
            }

            String[] credentials = userInterface.getCredentials(userInput);
            if (credentials != null) {
                Student student = userInterface.getStudent(credentials);
                studentsMap.addStudent(student);
            }
        } while (currCommand != Commands.BACK);
    }

    private void printAllStudentIds() {
        userInterface.printAllStudentIds(studentsMap.getAllStudentIds());
    }

    private void addPointProcess() {
        userInterface.printAddPointPrompt();
        do {
            String userInput = userInterface.getUserInput();
            if (userInput.equalsIgnoreCase(Commands.BACK.getDescription())) {
                currCommand = Commands.BACK;
                return;
            }

            int indexOfFirstSpace = userInput.indexOf(" ");
            int studentId = 0;
            try {
                studentId = Integer.parseInt(userInput.substring(0, indexOfFirstSpace));
            } catch (NumberFormatException e) {
                userInterface.printNoStudentById(userInput.substring(0, indexOfFirstSpace));
            }

            userInput = userInput.substring(indexOfFirstSpace + 1);
            //JAVA, DSA, DB, SPRING
            int[] studentPoints = userInterface.getPoints(userInput);
            if (studentPoints == null) {
                continue;
            }

            Student currentStudent = studentsMap.getStudentById(studentId);
            if (currentStudent == null) {
                continue;
            }

            currentStudent.addPoints(studentPoints);

            AddPoints addPoints = new AddPoints(studentId, studentPoints);
            addPointsHistory.add(addPoints);
            userInterface.printPointsAdded();

            //if the current amount of student points = max amount, change notification state to true
            boolean[] studentNotifications = currentStudent.getNotifications();
            for(int i = 0; i < studentPoints.length; i++){
                if(studentPoints[i] == Course.getMaxPointsByIndex(i)
                && !studentNotifications[i]){
                    studentNotifications[i] = true;
                }
            }
            currentStudent.setNotifications(studentNotifications);
        } while (currCommand != Commands.BACK);
    }

    private void findStudentProcess() {
        userInterface.printEnterIdPrompt();
        do {
            String userInput = userInterface.getUserInput();
            if (userInput.equalsIgnoreCase(Commands.BACK.getDescription())) {
                currCommand = Commands.BACK;
                return;
            }

            if (userInput.isBlank()) {
                continue;
            }

            int id = 0;
            try {
                id = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                userInterface.printNoStudentById(userInput);
                continue;
            }

            Student currentStudent = studentsMap.getStudentById(id);
            if (currentStudent == null) {
                continue;
            }
            userInterface.printInfoAboutStudentPoints(currentStudent);

        } while (currCommand != Commands.BACK);
    }

    private void printStatistics() {
        userInterface.printNameCoursePrompt();
        if (addPointsHistory.isEmpty()) {
            userInterface.printGeneralStatisticsNoData();
        }else {
            List<String> theMostPopularCourses = new ArrayList<>(Statistics.theMostPopularCourse(studentsMap));
            List<String> theLeastPopularCourses = new ArrayList<>(Statistics.theLeastPopularCourse(studentsMap));
            List<String> theHighestActivityCourses = new ArrayList<>(Statistics.theHighestActivityCourse(addPointsHistory));
            List<String> theLowestActivityCourses = new ArrayList<>(Statistics.theLowestActivityCourse(addPointsHistory));
            List<String> theEasiestCourses = new ArrayList<>(Statistics.theEasiestCourse(addPointsHistory));
            List<String> theHardestCourses = new ArrayList<>(Statistics.theHardestCourse(addPointsHistory));
            userInterface.printGeneralStatisticsAboutCourses(theMostPopularCourses,
                    theLeastPopularCourses,
                    theHighestActivityCourses,
                    theLowestActivityCourses,
                    theEasiestCourses,
                    theHardestCourses);
        }

        getDetailInformationAboutCourse();
    }



    public void getDetailInformationAboutCourse(){
        do {
            String userInput = userInterface.getUserInput().toLowerCase();
            if (userInput.equalsIgnoreCase(Commands.BACK.getDescription())) {
                currCommand = Commands.BACK;
                return;
            }

            Course currCourse = switch (userInput) {
                case "java" -> Course.JAVA;
                case "dsa" -> Course.DSA;
                case "databases" -> Course.DB;
                case "spring" -> Course.SPRING;
                default -> null;
            };

            if (currCourse == null) {
                userInterface.printUnknownCourse();
                continue;
            }

            List<DetailCourseInformation> studentsOnCourse = new ArrayList<>(studentsMap.getDetailInfoAboutStudentOnCourse(currCourse));
            userInterface.printDetailInformationAboutCourse(currCourse, studentsOnCourse);
        }while (currCommand != Commands.BACK);
    }

    private void notifyStudentsProcess(){
        int counterStudentsToSentNotifications = 0;
        for(Student student:studentsMap.getAllStudents()){
            int counterSentNotifications = 0;
            for(int i = 0; i < student.getNotifications().length; i++){
                if(student.getNotifications()[i]){
                    userInterface.printEmailNotificationForStudent(student,Course.getCourseByIndex(i));
                    ++counterSentNotifications;

                    //change the status of the student's notification
                    student.setNotificationToFalse(i);
                }
            }
            if(counterSentNotifications > 0){
                ++counterStudentsToSentNotifications;
            }
        }
        userInterface.printTotalInformationAboutNotifications(counterStudentsToSentNotifications);
    }
}

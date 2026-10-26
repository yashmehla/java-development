import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application class for the Student Records system.
 * Handles console menu interactions, user inputs, and delegates
 * record operations to appropriate management methods.
 */
public class Main {

    // Storage for student records using ArrayList
    private static final ArrayList<Student> studentList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("==================================================");
        System.out.println("       WELCOME TO STUDENT RECORDS DASHBOARD       ");
        System.out.println("==================================================");

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    handleAddStudent();
                    break;
                case 2:
                    handleDisplayAllStudents();
                    break;
                case 3:
                    handleSearchStudent();
                    break;
                case 4:
                    System.out.println("\nThank you for using Student Records Dashboard. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\n[!] Invalid choice! Please select an option between 1 and 4.");
            }
        }

        scanner.close();
    }

    /**
     * Displays the interactive console menu.
     */
    private static void displayMenu() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("                    MAIN MENU                     ");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Add a Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by Roll Number");
        System.out.println("4. Exit");
        System.out.println("--------------------------------------------------");
        System.out.print("Enter your choice (1-4): ");
    }

    /**
     * Safely reads the user's menu choice as an integer.
     *
     * @return Integer option selected, or -1 if input is non-numeric.
     */
    private static int getUserChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Indicates invalid numeric input
        }
    }

    /**
     * Handles the workflow for adding a new student record.
     */
    private static void handleAddStudent() {
        System.out.println("\n--- [ Add New Student ] ---");

        int rollNumber = readValidRollNumber("Enter Roll Number: ");
        if (rollNumber == -1) {
            return;
        }

        // Check for duplicate roll numbers
        if (findStudentByRollNumber(rollNumber) != null) {
            System.out.println("[Error] A student with Roll Number " + rollNumber + " already exists. Duplicate roll numbers are not allowed.");
            return;
        }

        String name = readValidName("Enter Student Name: ");
        if (name == null) {
            return;
        }

        // Add the new student to the ArrayList
        Student newStudent = new Student(rollNumber, name);
        studentList.add(newStudent);
        System.out.println("[Success] Student record added successfully!");
    }

    /**
     * Displays all stored student records or a message if empty.
     */
    private static void handleDisplayAllStudents() {
        System.out.println("\n--- [ All Student Records ] ---");

        if (studentList.isEmpty()) {
            System.out.println("No records found. The student list is currently empty.");
            return;
        }

        System.out.printf("%-15s %-30s%n", "Roll Number", "Student Name");
        System.out.println("--------------------------------------------------");
        for (Student student : studentList) {
            System.out.printf("%-15d %-30s%n", student.getRollNumber(), student.getName());
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Total Students: " + studentList.size());
    }

    /**
     * Handles searching for a student by roll number.
     */
    private static void handleSearchStudent() {
        System.out.println("\n--- [ Search Student by Roll Number ] ---");

        if (studentList.isEmpty()) {
            System.out.println("No records found. The student list is currently empty.");
            return;
        }

        int rollNumber = readValidRollNumber("Enter Roll Number to search: ");
        if (rollNumber == -1) {
            return;
        }

        Student foundStudent = findStudentByRollNumber(rollNumber);
        if (foundStudent != null) {
            System.out.println("\n[Record Found]");
            System.out.println("Roll Number : " + foundStudent.getRollNumber());
            System.out.println("Name        : " + foundStudent.getName());
        } else {
            System.out.println("[Not Found] No student found with Roll Number: " + rollNumber);
        }
    }

    /**
     * Searches for a student in the list matching the given roll number.
     *
     * @param rollNumber The roll number to look for.
     * @return Student object if found, or null otherwise.
     */
    private static Student findStudentByRollNumber(int rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    /**
     * Prompts the user and safely parses a positive integer for roll number.
     *
     * @param prompt Prompt message to display.
     * @return Valid positive roll number, or -1 if invalid.
     */
    private static int readValidRollNumber(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("[Error] Roll number cannot be empty.");
            return -1;
        }

        try {
            int rollNumber = Integer.parseInt(input);
            if (rollNumber <= 0) {
                System.out.println("[Error] Roll number must be a positive integer greater than zero.");
                return -1;
            }
            return rollNumber;
        } catch (NumberFormatException e) {
            System.out.println("[Error] Invalid input. Roll number must be a valid integer number (e.g., 101).");
            return -1;
        }
    }

    /**
     * Prompts the user and reads a non-empty student name.
     *
     * @param prompt Prompt message to display.
     * @return Valid trimmed student name, or null if empty.
     */
    private static String readValidName(String prompt) {
        System.out.print(prompt);
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("[Error] Student name cannot be empty.");
            return null;
        }
        return name;
    }
}

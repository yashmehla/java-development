/**
 * Represents a student with a unique roll number and name.
 * Demonstrates Object-Oriented Programming (OOP) principles such as encapsulation.
 */
public class Student {
    private int rollNumber;
    private String name;

    /**
     * Parameterized constructor to initialize a student record.
     *
     * @param rollNumber Unique integer identifier for the student.
     * @param name       Full name of the student.
     */
    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    /**
     * Gets the roll number of the student.
     *
     * @return roll number
     */
    public int getRollNumber() {
        return rollNumber;
    }

    /**
     * Gets the name of the student.
     *
     * @return student name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Employee Manager ---");
            System.out.println("1. Add Employee");
            System.out.println("2. List All Employees");
            System.out.println("3. Search by Department");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    listAllEmployees();
                    break;
                case 3:
                    searchByDepartment();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        employees.add(new Employee(id, name, department));
        System.out.println("Employee added successfully!");
    }

    private static void listAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n--- All Employees ---");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void searchByDepartment() {
        System.out.print("Enter Department to search: ");
        String searchDept = scanner.nextLine();
        boolean found = false;

        System.out.println("\n--- Search Results ---");
        for (Employee emp : employees) {
            if (emp.getDepartment().equalsIgnoreCase(searchDept)) {
                System.out.println(emp);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in the " + searchDept + " department.");
        }
    }
}

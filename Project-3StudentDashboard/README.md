# Project 3: Student Records Dashboard

A beginner-friendly Java console application designed to manage student records (Roll Number and Name) using Java Object-Oriented Programming (OOP) concepts and Collections (`ArrayList`).

---

## Table of Contents
- [Project Description](#project-description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Repository Structure](#repository-structure)
- [Compilation and Execution](#compilation-and-execution)
- [Example Program Output](#example-program-output)
- [Test Cases](#test-cases)
- [Code Architecture](#code-architecture)

---

## Project Description

The **Student Records Dashboard** is an interactive, menu-driven command-line tool for managing basic student information. The application allows users to add new student records, display all stored students in a clean tabular view, and search for specific students using their unique roll numbers. 

The project enforces core software design principles such as:
- **Encapsulation**: Student properties (`rollNumber`, `name`) are kept private and accessed via public getter methods.
- **Data Integrity**: Duplicate roll numbers are detected and rejected.
- **Robust Input Handling**: User inputs are validated without crashing or causing unexpected program termination.
- **Separation of Concerns**: Student entity state is separated from input parsing and user interface logic.

---

## Features

- **Add Student**: Add a student with a unique roll number and name.
- **Display All Students**: View all registered students in a formatted tabular list.
- **Search by Roll Number**: Quickly look up a student's record using their unique roll number.
- **Duplicate Prevention**: Rejects duplicate roll number entries and notifies the user with clear feedback.
- **Input Validation & Crash Prevention**:
  - Handles non-numeric inputs (e.g., typing letters for roll numbers or menu options).
  - Handles negative numbers or zero for roll numbers.
  - Rejects empty or whitespace-only names.
- **Friendly Empty-State Messaging**: Informs the user when no records exist.

---

## Technologies Used

- **Language**: Java (Java SE 8 or higher; tested on Java 25 LTS)
- **Data Structures**: `java.util.ArrayList`
- **I/O Handling**: `java.util.Scanner`
- **Build Tool / Dependencies**: None (Standard Java SDK only)

---

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or newer installed on your machine.
- Verify installation by running:
  ```bash
  javac -version
  java -version
  ```

---

## Repository Structure

```
Project-3StudentDashboard/
│
├── src/
│   ├── Student.java    # Student entity class (data model)
│   └── Main.java       # Menu UI, input handling, and record management logic
│
├── .gitignore          # Git ignore rules for compiled classes and IDE metadata
└── README.md           # Project documentation and test specifications
```

---

## Compilation and Execution

### 1. Navigate to the project directory:
```bash
cd Project-3StudentDashboard
```

### 2. Compile the Java files:
You can compile the source files directly into a `bin` directory:
```bash
# Windows / Linux / macOS
javac -d bin src/Student.java src/Main.java
```

Or compile directly inside `src/`:
```bash
javac src/Student.java src/Main.java
```

### 3. Run the application:
If compiled into `bin`:
```bash
java -cp bin Main
```

If compiled inside `src`:
```bash
java -cp src Main
```

---

## Example Program Output

### Welcome & Main Menu
```text
==================================================
       WELCOME TO STUDENT RECORDS DASHBOARD       
==================================================

--------------------------------------------------
                    MAIN MENU                     
--------------------------------------------------
1. Add a Student
2. Display All Students
3. Search Student by Roll Number
4. Exit
--------------------------------------------------
Enter your choice (1-4): 
```

### Adding a Student
```text
Enter your choice (1-4): 1

--- [ Add New Student ] ---
Enter Roll Number: 101
Enter Student Name: Yash Mehla
[Success] Student record added successfully!
```

### Displaying All Students
```text
Enter your choice (1-4): 2

--- [ All Student Records ] ---
Roll Number     Student Name                  
--------------------------------------------------
101             Yash Mehla                    
102             Alex Brown                    
--------------------------------------------------
Total Students: 2
```

### Searching for a Student (Found)
```text
Enter your choice (1-4): 3

--- [ Search Student by Roll Number ] ---
Enter Roll Number to search: 101

[Record Found]
Roll Number : 101
Name        : Yash Mehla
```

### Duplicate Roll Number Handling
```text
Enter your choice (1-4): 1

--- [ Add New Student ] ---
Enter Roll Number: 101
[Error] A student with Roll Number 101 already exists. Duplicate roll numbers are not allowed.
```

---

## Test Cases

| Test Case ID | Scenario | Input Given | Expected Output | Status |
| :--- | :--- | :--- | :--- | :--- |
| **TC-01** | Display records when list is empty | Option `2` | `No records found. The student list is currently empty.` | **PASSED** |
| **TC-02** | Search when list is empty | Option `3` | `No records found. The student list is currently empty.` | **PASSED** |
| **TC-03** | Add valid student | Option `1` -> Roll: `101`, Name: `Yash Mehla` | `[Success] Student record added successfully!` | **PASSED** |
| **TC-04** | Add second valid student | Option `1` -> Roll: `102`, Name: `Alex Brown` | `[Success] Student record added successfully!` | **PASSED** |
| **TC-05** | Attempt duplicate roll number | Option `1` -> Roll: `101` | `[Error] A student with Roll Number 101 already exists. Duplicate roll numbers are not allowed.` | **PASSED** |
| **TC-06** | Invalid roll number (negative) | Option `1` -> Roll: `-5` | `[Error] Roll number must be a positive integer greater than zero.` | **PASSED** |
| **TC-07** | Invalid roll number (alphanumeric) | Option `1` -> Roll: `abc` | `[Error] Invalid input. Roll number must be a valid integer number (e.g., 101).` | **PASSED** |
| **TC-08** | Empty student name | Option `1` -> Roll: `103`, Name: `""` | `[Error] Student name cannot be empty.` | **PASSED** |
| **TC-09** | Display populated list | Option `2` | Tabular display showing records for roll numbers 101 and 102 with count of 2 | **PASSED** |
| **TC-10** | Search existing roll number | Option `3` -> Roll: `101` | `[Record Found]` with Roll Number: `101`, Name: `Yash Mehla` | **PASSED** |
| **TC-11** | Search non-existent roll number | Option `3` -> Roll: `999` | `[Not Found] No student found with Roll Number: 999` | **PASSED** |
| **TC-12** | Search with invalid roll number | Option `3` -> Roll: `xyz` | `[Error] Invalid input. Roll number must be a valid integer number (e.g., 101).` | **PASSED** |
| **TC-13** | Invalid menu choice (out-of-range) | Choice: `99` | `[!] Invalid choice! Please select an option between 1 and 4.` | **PASSED** |
| **TC-14** | Invalid menu choice (non-numeric) | Choice: `menu` | `[!] Invalid choice! Please select an option between 1 and 4.` | **PASSED** |
| **TC-15** | Exit application gracefully | Choice: `4` | `Thank you for using Student Records Dashboard. Goodbye!` (Process exits with code 0) | **PASSED** |

---

## Code Architecture

- **`Student.java`**:
  - `rollNumber` (`int`): Private field storing student's unique identifier.
  - `name` (`String`): Private field storing student's full name.
  - `Student(int, String)`: Parameterized constructor.
  - `getRollNumber()`, `getName()`: Accessor methods ensuring encapsulation.
  - `toString()`: String representation override.

- **`Main.java`**:
  - `studentList` (`ArrayList<Student>`): Dynamic list storing student records in memory.
  - `displayMenu()`: Renders options to the user.
  - `getUserChoice()`: Parses menu options safely using `Integer.parseInt` inside a `try-catch` block.
  - `handleAddStudent()`: Orchestrates roll number validation, duplicate verification, and record creation.
  - `handleDisplayAllStudents()`: Iterates over records and prints tabular formatted output.
  - `handleSearchStudent()`: Queries `studentList` by roll number.
  - `findStudentByRollNumber(int)`: Helper method performing linear search on `studentList`.

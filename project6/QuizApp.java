import java.util.Scanner;

class Question {
    String prompt;
    String[] options;
    int correctIndex;

    public Question(String prompt, String[] options, int correctIndex) {
        this.prompt = prompt;
        this.options = options;
        this.correctIndex = correctIndex;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Question[] quiz = {
            new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"implements", "extends", "inherits", "super"},
                1
            ),
            new Question(
                "What is the default value of a boolean variable in Java?",
                new String[]{"true", "0", "false", "null"},
                2
            ),
            new Question(
                "Which data type is used to create a variable that should store text?",
                new String[]{"myString", "Txt", "string", "String"},
                3
            ),
            new Question(
                "Which method is the entry point of a Java program?",
                new String[]{"start()", "init()", "main()", "run()"},
                2
            )
        };

        int score = 0;

        System.out.println("=== Welcome to the Java MCQ Quiz! ===");
        System.out.println("Enter the number (1-4) corresponding to your answer.\n");

        for (int i = 0; i < quiz.length; i++) {
            Question current = quiz[i];
            System.out.println("Q" + (i + 1) + ": " + current.prompt);

            for (int j = 0; j < current.options.length; j++) {
                System.out.println("  " + (j + 1) + ". " + current.options[j]);
            }

            int userChoice = -1;
            while (userChoice < 1 || userChoice > current.options.length) {
                System.out.print("Your answer (1-" + current.options.length + "): ");
                if (scanner.hasNextInt()) {
                    userChoice = scanner.nextInt();
                } else {
                    scanner.next();
                }
            }

            if (userChoice - 1 == current.correctIndex) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " 
                    + current.options[current.correctIndex] + "\n");
            }
        }

        System.out.println("=== Quiz Finished! ===");
        System.out.println("Your Final Score: " + score + " out of " + quiz.length);

        scanner.close();
    }
}

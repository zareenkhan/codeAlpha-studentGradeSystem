import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array of subject names
        String[] subjects = {"English", "Urdu", "Maths", "Computer", "Science"};
        int[] grades = new int[subjects.length];

        // Ask for student's name
        System.out.print("Enter the student's name: ");
        String studentName = scanner.nextLine();

        System.out.println("Enter the grades for each subject:");

        // Input loop for grades
        for (int i = 0; i < subjects.length; i++) {
            while (true) {
                System.out.print(subjects[i] + ": ");
                int grade = scanner.nextInt();

                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                } else {
                    grades[i] = grade;
                    break;
                }
            }
        }

        // Process and display the results
        double average = calculateAverage(grades);
        int highest = findHighest(grades);
        int lowest = findLowest(grades);

        System.out.println("\nGrade Summary for " + studentName + ":");
        System.out.println("Average score: " + average);
        System.out.println("Highest score: " + highest + " in " + subjects[findHighestIndex(grades)]);
        System.out.println("Lowest score: " + lowest + " in " + subjects[findLowestIndex(grades)]);
        System.out.println("Thank you, have a nice day!");
        scanner.close();
    }

    // Method to calculate the average score
    private static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    // Method to find the highest score
    private static int findHighest(int[] grades) {
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest score
    private static int findLowest(int[] grades) {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    // Method to find the index of the highest score
    private static int findHighestIndex(int[] grades) {
        int highestIndex = 0;
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > grades[highestIndex]) {
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    // Method to find the index of the lowest score
    private static int findLowestIndex(int[] grades) {
        int lowestIndex = 0;
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < grades[lowestIndex]) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }
}

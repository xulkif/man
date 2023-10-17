

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        String[] names = new String[n];
        char[] sexes = new char[n];
        int[] finalMarks = new int[n];
        int[] midMarks = new int[n];
        int[] assignmentMarks = new int[n];

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Name: ");
            names[i] = scanner.next();
            System.out.print("Sex (M/F): ");
            sexes[i] = scanner.next().charAt(0);
            System.out.print("Final Exam Marks (out of 50): ");
            finalMarks[i] = scanner.nextInt();
            System.out.print("Mid Exam Marks (out of 30): ");
            midMarks[i] = scanner.nextInt();
            System.out.print("Assignment Marks (out of 20): ");
            assignmentMarks[i] = scanner.nextInt();
            System.out.println();
        }

        // Calculate overall marks and rank students
        int[] overallMarks = calculateOverallMarks(finalMarks, midMarks, assignmentMarks);
        String[] rankings = getRankings(overallMarks);

        // Print student details and rankings
        System.out.println("Student Mark Management System");
        System.out.println("==============================");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " - " + names[i]);
            System.out.println("Sex: " + sexes[i]);
            System.out.println("Overall Marks: " + overallMarks[i]);
            System.out.println("Rank: " + rankings[i]);
            System.out.println();
        }
    }

    // Calculate overall marks for each student
    public static int[] calculateOverallMarks(int[] finalMarks, int[] midMarks, int[] assignmentMarks) {
        int n = finalMarks.length;
        int[] overallMarks = new int[n];

        for (int i = 0; i < n; i++) {
            overallMarks[i] = finalMarks[i] + midMarks[i] + assignmentMarks[i];
        }

        return overallMarks;
    }

    // Get rankings based on overall marks
    public static String[] getRankings(int[] overallMarks) {
        int n = overallMarks.length;
        String[] rankings = new String[n];

        // Sort overall marks in descending order
        int[] sortedMarks = overallMarks.clone();
        java.util.Arrays.sort(sortedMarks);

        // Assign rankings based on sorted marks
        for (int i = 0; i < n; i++) {
            int rank = n - java.util.Arrays.binarySearch(sortedMarks, overallMarks[i]);
            rankings[i] = "Rank " + rank;
        }

        return rankings;
    }
}



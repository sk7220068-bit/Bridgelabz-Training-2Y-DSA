import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        // marks[i][0] = Physics, marks[i][1] = Chemistry, marks[i][2] = Maths
        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            System.out.print("Physics: ");
            int physics = scanner.nextInt();
            System.out.print("Chemistry: ");
            int chemistry = scanner.nextInt();
            System.out.print("Maths: ");
            int maths = scanner.nextInt();

            if (physics < 0 || chemistry < 0 || maths < 0) {
                System.out.println("Invalid input. Marks cannot be negative.");
                i--;
                continue;
            }

            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = maths;

            int total = physics + chemistry + maths;
            percentages[i] = total / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        System.out.println("\nStudent Grades Report:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Phy=" + marks[i][0] + ", Chem=" + marks[i][1] + ", Maths="
                    + marks[i][2] + ", Percentage=" + String.format("%.2f", percentages[i]) + "%, Grade=" + grades[i]);
        }

        scanner.close();
    }
}

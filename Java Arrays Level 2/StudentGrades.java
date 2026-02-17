import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] physicsMarks = new int[n];
        int[] chemistryMarks = new int[n];
        int[] mathsMarks = new int[n];
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

            physicsMarks[i] = physics;
            chemistryMarks[i] = chemistry;
            mathsMarks[i] = maths;

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
            System.out.println("Student " + (i + 1) + ": Phy=" + physicsMarks[i] + ", Chem=" + chemistryMarks[i]
                    + ", Maths=" + mathsMarks[i] + ", Percentage=" + String.format("%.2f", percentages[i]) + "%, Grade="
                    + grades[i]);
        }

        scanner.close();
    }
}

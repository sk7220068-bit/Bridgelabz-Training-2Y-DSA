import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of games:");
        int n = scanner.nextInt();

        int userWins = 0;
        int computerWins = 0;
        String[][] gameHistory = new String[n][3];

        for (int i = 0; i < n; i++) {
            System.out.println("\nGame " + (i + 1));
            System.out.println("Enter choice (Rock, Paper, Scissors):");
            String userChoice = scanner.next();
            String computerChoice = getComputerChoice();
            String winner = getWinner(userChoice, computerChoice);

            gameHistory[i][0] = userChoice;
            gameHistory[i][1] = computerChoice;
            gameHistory[i][2] = winner;

            if (winner.equals("User")) {
                userWins++;
                System.out.println("You Win!");
            } else if (winner.equals("Computer")) {
                computerWins++;
                System.out.println("Computer Wins!");
            } else {
                System.out.println("Draw!");
            }
            System.out.println("Computer chose: " + computerChoice);
        }

        displayGameStats(gameHistory);
        displayWinPercentage(userWins, computerWins, n);
        scanner.close();
    }

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0)
            return "Rock";
        else if (choice == 1)
            return "Paper";
        else
            return "Scissors";
    }

    public static String getWinner(String user, String computer) {
        if (user.equalsIgnoreCase(computer))
            return "Draw";

        if (user.equalsIgnoreCase("Rock")) {
            return computer.equals("Scissors") ? "User" : "Computer";
        } else if (user.equalsIgnoreCase("Paper")) {
            return computer.equals("Rock") ? "User" : "Computer";
        } else if (user.equalsIgnoreCase("Scissors")) {
            return computer.equals("Paper") ? "User" : "Computer";
        }
        return "Invalid";
    }

    public static void displayGameStats(String[][] history) {
        System.out.println("\nGame Stats:");
        System.out.println("Game\tUser\tComputer\tWinner");
        System.out.println("----\t----\t--------\t------");
        for (int i = 0; i < history.length; i++) {
            System.out.println((i + 1) + "\t" + history[i][0] + "\t" + history[i][1] + "\t\t" + history[i][2]);
        }
    }

    public static void displayWinPercentage(int userWins, int computerWins, int totalGames) {
        double userPercentage = (double) userWins / totalGames * 100;
        double computerPercentage = (double) computerWins / totalGames * 100;
        System.out.println("\nWin Percentage:");
        System.out.printf("User: %.2f%%\n", userPercentage);
        System.out.printf("Computer: %.2f%%\n", computerPercentage);
    }
}

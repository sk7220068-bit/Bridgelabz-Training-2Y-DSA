import java.util.Scanner;

public class DeckOfCards {

    public static String[] initializeDeck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        String[] deck = new String[suits.length * ranks.length];

        int count = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[count++] = ranks[j] + " of " + suits[i];
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomCardNumber = i + (int) (Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        if (players * cardsPerPlayer > deck.length) {
            System.out.println("Not enough cards to distribute.");
            return new String[0][0];
        }

        String[][] playerHands = new String[players][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerHands[i][j] = deck[cardIndex++];
            }
        }
        return playerHands;
    }

    public static void displayPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int players = scanner.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = scanner.nextInt();

        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);
        String[][] playerHands = distributeCards(deck, players, cardsPerPlayer);

        if (playerHands.length > 0) {
            displayPlayers(playerHands);
        }
        scanner.close();
    }
}

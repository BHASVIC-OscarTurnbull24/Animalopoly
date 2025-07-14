import java.util.Objects;
import java.util.Random;

public class Cards {

    private String[][] cards = {
            {"You gain 20A$", "20"},
            {"You lose 20A$", "-20", "M"},
            {"You gain 30A$", "30", "M"},
            {"You lose 30A$", "-30", "M"},
            {"You gain 50A$", "50", "M"},
            {"You lose 50A$", "-50", "M"},
            {"You gain 100A$", "100", "M"},
            {"You lose 100A$", "-100", "M"},
            {"You move forward 2 spaces", "2", "S"},
            {"You move backward 2 spaces", "-2", "S"},
            {"You move forward 3 spaces", "3", "S"},
            {"You move backward 3 spaces", "-3", "S"},
            {"You move forward 5 spaces", "5",  "S"},
            {"You move backward 5 spaces", "-5", "S"},
            {"You move forward 8 spaces", "8", "S"},
            {"You move backward 8 spaces", "-8", "S"}
    };

    private int currentCard = 0;

    public Cards() {
        shuffleCards(cards);
    }

    public void drawCards(Player currentPlayer, Board board) {

        if (currentCard >= cards.length) {
            shuffleCards(cards);
            currentCard = 0;
            System.out.println("The deck has been shuffled.");
        }

        String text = cards[currentCard][0];
        int value = Integer.parseInt(cards[currentCard][1]);
        String mOrS =  cards[currentCard][2];

        System.out.println("You rolled a double. Draw a card");
        System.out.println(text);

        if (Objects.equals(mOrS, "M")) {
            currentPlayer.addMoney(value);
        }
        else if (Objects.equals(mOrS, "S")) {
            board.movePlayer(currentPlayer, value);
        }
        else {
            System.out.println("error.");
        }
        currentCard++;
    }

    public static void shuffleCards(String[][] cards) {

        Random random = new Random();

        for (int i = 0; i < cards.length; i++) {
            int n = random.nextInt(cards.length);
            String[] temp = cards[i];
            cards[i] = cards[n];
            cards[n] = temp;
        }
        System.out.println("The deck has been shuffled.");
    }
}

import java.util.ArrayList;

public class Game {

    private Player p1;
    private Player p2;
    private Deck deck;

    public Game() {
        this.p1 = new Player("player 1");
        this.p2 = new Player("player 2");
        this.deck = new Deck();
    }

    public void startGame() {
        System.out.println("shuffling deck...");
        deck.shuffle();

        System.out.println("dealing cards...");
        dealCards();

        System.out.println("game starting...");
        while (p1.hasCards() && p2.hasCards()) {
            playRound();
        }
        gameOver();
    }

    private void dealCards() {
        while (!deck.isEmpty()) {
            p1.drawCard(deck.deal());
            p2.drawCard(deck.deal());
        }
    }

    private void playRound() {
        ArrayList<Card> pot = new ArrayList<>();

        Card p1Card = p1.playCard();
        Card p2Card = p2.playCard();

        System.out.println(p1.getName() + " plays " + p1Card);
        System.out.println(p2.getName() + " plays " + p2Card);

        pot.add(p1Card);
        pot.add(p2Card);

        int p1Value = p1Card.getValue();
        int p2Value = p2Card.getValue();

        if (p1Value > p2Value) {
            p1.addCards(pot);
            System.out.println(p1.getName() + " wins the round!");
        } else if (p2Value > p1Value) {
            p2.addCards(pot);
            System.out.println(p2.getName() + " wins the round!");
        } else {
            playWar(pot);
        }
    }

    private void playWar(ArrayList<Card> pot) {
        System.out.println("war!");

        while (p1.hasCards() && p2.hasCards()) {

            for (int i = 0; i < 3; i++) {
                if (p1.hasCards()) {
                    pot.add(p1.playCard());
                }
                if (p2.hasCards()) {
                    pot.add(p2.playCard());
                }
            }

            if (!p1.hasCards()) {
                p2.addCards(pot);
                return;
            }
            if (!p2.hasCards()) {
                p1.addCards(pot);
                return;
            }

            Card p1Card = p1.playCard();
            Card p2Card = p2.playCard();

            System.out.println(p1.getName() + " plays " + p1Card);
            System.out.println(p2.getName() + " plays " + p2Card);

            pot.add(p1Card);
            pot.add(p2Card);

            int p1Value = p1Card.getValue();
            int p2Value = p2Card.getValue();

            if (p1Value > p2Value) {
                p1.addCards(pot);
                System.out.println(p1.getName() + " wins the war!");
                return;
            } else if (p2Value > p1Value) {
                p2.addCards(pot);
                System.out.println(p2.getName() + " wins the war!");
                return;
            }
            System.out.println("another war!");
        }
    }

    private void gameOver() {
        if (!p1.hasCards()) {
            System.out.println("player 2 won the game!");
        } else {
            System.out.println("player 1 won the game!");
        }
    }
}

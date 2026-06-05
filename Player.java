import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Player {

    private String name;
    private Queue<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Card playCard() {
        return hand.poll();
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public void addCards(ArrayList<Card> cards) {
        hand.addAll(cards);
    }
}

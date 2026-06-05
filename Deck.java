import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        buildDeck();
    }

    private void buildDeck() {
        String[] suits = {"spades", "clubs", "hearts", "diamonds"};
        String[] ranks = {"two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "jack", "queen", "king", "ace"};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(ranks[i], suit, i + 2));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.removeFirst();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
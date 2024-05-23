package card;

import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and optionally includes a hard-coded lucky card based on random chance.
 * To be used as starting code in ICE 1
 * @author sumit kaplish
 * Student number:991731685
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        // Define the lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(4);
        luckyCard.setSuit("Hearts"); 

        // Randomly decide to include the lucky card or not
        boolean includeLuckyCard = rand.nextBoolean();
        int luckyIndex = includeLuckyCard ? rand.nextInt(magicHand.length) : -1;

        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            if (i == luckyIndex) {
                magicHand[i] = luckyCard;
            } else {
                Card c = new Card();
                c.setValue(rand.nextInt(13) + 1); 
                c.setSuit(suits[rand.nextInt(suits.length)]);
                magicHand[i] = c;
            }
        }

        // Display all cards in the magic hand
        System.out.println("Magic Hand Cards:");
        for (Card card : magicHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        // Check if the lucky card is in the magic hand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.equals(luckyCard)) {
                found = true;
                break;
            }
        }

        // Report result for the lucky card
        if (found) {
            System.out.println("The lucky card (4 of Hearts) is in the magic hand. You win!");
        } else {
            System.out.println("The lucky card (4 of Hearts) is not in the magic hand. You lose.");
        }
    }
}

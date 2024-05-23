/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and optionally includes a hard-coded lucky card based on random chance.
 * To be used as starting code in ICE 1
 * @author Parneet Kaur
 * Student number:991724032
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        
        Card luckyCard = new Card();
        luckyCard.setValue(4);
        luckyCard.setSuit("SPADES");


        boolean includeLuckyCard = rand.nextBoolean();
        int luckyIndex = includeLuckyCard ? rand.nextInt(magicHand.length) : -1; 
        
        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            if (i == luckyIndex) {
                // Place the lucky card at the determined position
                magicHand[i] = luckyCard;
            } else {
                Card c = new Card();
                c.setValue(rand.nextInt(13) + 1); // Values from 1 to 13
                c.setSuit(suits[rand.nextInt(suits.length)]); // Random suit
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
            System.out.println("The lucky card (4 of SPADES) is in the magic hand. You win!");
        } else {
            System.out.println("The lucky card (4 of SPADES) is not in the magic hand. You lose.");
        }
    }
}


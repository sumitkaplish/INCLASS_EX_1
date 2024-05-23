/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author sumit kaplish
 * Student number:991731685
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        System.out.println("Randomly generated cards in the magic hand:");
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1);  
            c.setSuit(suits[rand.nextInt(4)]); 
            magicHand[i] = c;
            System.out.println(c.getValue() + " of " + c.getSuit());
        }

        Scanner in = new Scanner(System.in);
        int value = 0;
        while (true) {
            System.out.println("Enter the card value (1-13): ");
            if (in.hasNextInt()) {
                value = in.nextInt();
                if (value >= 1 && value <= 13) {
                    break;
                }
            } else {
                in.nextLine();  
            }
            System.out.println("Invalid input. Please enter a number from 1 to 13.");
        }
        in.nextLine(); 

        System.out.println("Enter a suit {Hearts, Diamonds, Clubs, Spades}:");
        String userSuit = in.nextLine();

        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(userSuit);

        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }

        // Adding a "lucky card" and checking its presence in the hand
        
        

        

    }
}

/*package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> deck = new ArrayList<Card>();
    private List<Card> usedCards = new ArrayList<Card>();

    //Constructor to create standard 52 card deck
    Deck(){
        buildDeck();
        shuffle();
       // for(int i = 0; i < 52; i++){
      //      System.out.println(deck.get(i))
       // }
    }
    //Build 52 card deck
    public void buildDeck(){
        int REDIX = 10;

        for(int i = 0; i < 4; i++){
            String cardSuit = "";
            //int cardValue = 0;
            //char cardRank = 'a';

            switch(i){
                case 0: cardSuit = "Clubs";
                    break;
                case 1: cardSuit = "Diamonds";
                    break;
                case 2: cardSuit = "Hearts";
                    break;
                case 3: cardSuit = "Spades";
            }

            for(int j = 2; j <= 14; j++){
                if(j <= 9){
                    deck.add(new Card(j,(Character.forDigit(j,REDIX)), cardSuit));
                }
                else if(j == 10){
                    deck.add(new Card(10, 'X', cardSuit ));
                }
                else if(j == 11){
                    deck.add(new Card(10, 'J', cardSuit));
                }
                else if(j == 12){
                    deck.add(new Card(10, 'Q', cardSuit));
                }
                else if(j == 13){
                    deck.add(new Card(10, 'K', cardSuit));
                }
                else if(j == 14){
                    deck.add(new Card(11, 'A', cardSuit));
                }
            }
        }
    }

    //Return number of cards in deck


    //Deal top card of deck
    public Card deal(){
        Card draw = deck.remove(0);
        usedCards.add(draw);
        return draw;
    }

    //Shuffle the deck
    public void shuffle(){
        Collections.shuffle(deck, new Random(System.currentTimeMillis()));
    }


}
*/
package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    //Will contain a standard 52 card deck
    private List<Card> deck = new ArrayList<Card>();
    //Used to hold the cards that have been played already to later be reshuffled into the deck
    private List<Card> usedCards = new ArrayList<Card>();

    //Constructor to create standard 52 card deck
    Deck(){
        buildDeck();
        shuffle();
    }
    //Build 52 card deck
    public void buildDeck(){
        int REDIX = 10;

        for(int i = 0; i < 4; i++){
            String cardSuit = "";

            //Assign a suit to the Card object
            switch(i){
                case 0: cardSuit = "Clubs";
                    break;
                case 1: cardSuit = "Diamonds";
                    break;
                case 2: cardSuit = "Hearts";
                    break;
                case 3: cardSuit = "Spades";
            }

            //Assign a value and rank to the Card Object
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
    public int sizeOfDeck(){
        return deck.size();
    }

    public Card getCardAtIndex(int index){
        return deck.get(index);
    }
    //Deal top card of deck
    public Card deal(){
        Card draw = deck.remove(0);
        usedCards.add(draw);
        return draw;
    }

    //The used Cards will be added back to the Undealt deck and the used Cards deck will be cleared
    public void newDeck(){
        this.deck.addAll(this.usedCards);
        this.usedCards.clear();
    }
    //Shuffle the deck
    public void shuffle(){
        Collections.shuffle(deck, new Random(System.currentTimeMillis()));
    }
}

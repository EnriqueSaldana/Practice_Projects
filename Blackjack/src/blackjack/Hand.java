package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand = new ArrayList<Card>();
    private int total = 0;

    Hand(){

    }

    //Deal a card to the dealer's hand
    public void deal(Deck deck){
        Card draw = deck.deal();
        this.hand.add(draw);
        total = total + draw.getValue();
    }

    //Deal a specific Card - use for testing purposes
    public void dealCard(Card c){
        this.hand.add(c);
    }

    //Returns total of the dealer's hand
    public int getTotal(){
        return this.total;
    }

    //Clears hand for the start of a new game
    public void newHand(){
        this.hand.clear();
        this.total = 0;
    }

    //Checks if the initial 2 cards dealt resulted in a Blackjack (21)
    public boolean checkForBlackjack(){
        if(this.hand.get(0).getValue() + this.hand.get(1).getValue() == 21){
            return true;
        }
        return false;
    }

    //Return String representation of the Cards on Dealer's hand
    public String toString(){
        String cardsInHand = "";
        for(int i = 0; i < this.hand.size(); i++){
            cardsInHand += this.hand.get(i).toString();
        }
        return cardsInHand;
    }
    
}

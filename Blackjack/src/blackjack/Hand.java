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

    //Returns total of the dealer's hand
    public int getTotal(){
        return this.total;
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

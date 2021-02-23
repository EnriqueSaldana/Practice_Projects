package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private List<Card> dealerHand = new ArrayList<Card>();
    private int total = 0;

    Dealer(){

    }

    //Deal a card to the dealer's hand
    public void deal(Deck deck){
        Card draw = deck.deal();
        dealerHand.add(draw);
        total = total + draw.getValue();
    }

    //Returns total of the dealer's hand
    public int getTotal(){
        return this.total;
    }

    //Return String representation of the Cards on Dealer's hand
    public String toString(){
        String hand = "";
        for(int i = 0; i < dealerHand.size(); i++){
            hand += dealerHand.get(i).toString();
        }
        return hand;
    }
    
}

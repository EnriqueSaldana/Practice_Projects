package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand = new ArrayList<Card>();
    private int total = 0;         // Hand total value
    private int aceCount = 0;      // Numbers of Aces in hand

    Hand(){

    }

    //Deal a card to the (Player's/Dealer's) hand
    public void deal(Deck deck){
        Card draw = deck.deal();
        this.hand.add(draw);
        checkForAce(draw);
        total = total + draw.getValue();
    }

    //Deal a specific Card - use for testing purposes
    public void dealCard(Card c){
        this.hand.add(c);
    }

    //Return list of cards on (Player's/Dealer's) hand
    public List<Card> getHand(){
        return this.hand;
    }

    //Returns total of the (Player's/Dealer's) hand
    public int getTotal(){
        return this.total;
    }

    //Set total to value passed
    public void setTotal(int t){
        this.total = t;
    }

    //Returns number of Aces in hand
    public int getAceCount(){
        return this.aceCount;
    }

    //Set aceCount to value passed
    public void setAceCount(int count){
        this.aceCount = count;
    }

    //Clears hand for the start of a new game
    public void newHand(){
        this.hand.clear();
        this.total = 0;
        this.aceCount = 0;
    }

    //Track if an Ace is drawn to later determine whether to use it as a 1 or 11
    public void checkForAce(Card c){
        if(c.getRank() == 'A'){
            aceCount++;
        }
    }

    //Checks if the initial 2 cards dealt resulted in a Blackjack (21)
    public boolean checkForBlackjack(){
        if(this.hand.get(0).getValue() + this.hand.get(1).getValue() == 21){
            return true;
        }
        return false;
    }

    //Check hand total for Bust (over 21)
    public boolean checkForBust(){
        if(this.getTotal() > 21){
            return true;
        }
        return false;
    }

    //Return String representation of the Cards on (Player's/Dealer's) hand
    public String toString(){
        String cardsInHand = "";
        for(int i = 0; i < this.hand.size(); i++){
            cardsInHand += this.hand.get(i).toString();
        }
        return cardsInHand;
    }  
}

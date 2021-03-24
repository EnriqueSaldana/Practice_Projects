package blackjack;

public class Dealer extends Hand{
    protected Deck deck;

    Dealer(Deck d){
        this.deck = d;
    }

    //Dealer will draw cards until his total is 17 or greater
    public void dealerTurn(){
        if(this.getTotal() > 16 && this.getTotal() <= 21){
            return;
        }
        else{
            while(this.getTotal() < 17){
                this.deal(deck);
                if(this.checkForBust()){
                    if(this.getAceCount() > 0){
                        this.setTotal(this.getTotal() - 10);
                        this.setAceCount(this.getAceCount() -1);
                    }
                }
            }
        }
    }

    //Print dealer hand with first card "face-up" and second card "face-down"
    public void printDealerHand(){
        String firstCard = "["+ this.getHand().get(0).getRank() + " " + this.getHand().get(0).getSuit() + "]";
        System.out.println("Dealer's Hand: " + firstCard + "[ ]");
    }
}

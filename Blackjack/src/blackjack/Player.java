package blackjack;

import java.util.Scanner;

public class Player extends Hand{
    protected Deck deck;
    protected char decision;

    Player(Deck d){
        this.deck = d;
    }

    //Ask for user input to determine if the player will stay or keep drawing cards
    public boolean playerTurn(Scanner in){
        if(this.checkForBlackjack()){
            return false;
        }
        System.out.println("Player's Hand: " + this.toString());

        //If hand is greater than 21 and there is an Ace in hand, the ace will be used as a 1 instead of 11
        if(this.checkForBust()){
            if(this.getAceCount() > 0){
                this.setTotal(this.getTotal() - 10);
                this.setAceCount(this.getAceCount() -1);
            }
            else{
                System.out.println("BUST!! : Total = " + this.getTotal());
                return false;
            }
        }
        System.out.println("Enter S for Stay or H for Hit");
        this.decision = in.next().charAt(0);

        if(decision == 'S'){
            return false;
        }
        else if(decision == 'H'){
            this.deal(deck);
            return true;
        }

        return false;
    }

}

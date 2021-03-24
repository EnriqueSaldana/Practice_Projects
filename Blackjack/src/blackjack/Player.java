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
        if(this.checkForBust()){
            System.out.println("BUST!! : Total = " + this.getTotal());
            return false;
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

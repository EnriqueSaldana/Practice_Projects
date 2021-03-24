package blackjack;

import java.util.Scanner;

public class Blackjack {

    public static void main(String args[]) {
        
        Boolean newGame = true;             //Used to determine if a new game will be played
        Boolean dealerWin = false;          //Used to determine if dealer has won the game
        Boolean playerBlackjack = false;    //Used to signal that player has drawn a Blackjack
        Boolean gameDraw = false;           //Used to determine if the game is a draw
        char playAgain;                     //User response when asked if they will play another game
        
        Scanner in = new Scanner(System.in);

        //Object initialization
        Deck deck = new Deck();
        Player player1 = new Player(deck);
        Dealer dealer1 = new Dealer(deck);

        //Gameplay
        while(newGame){
            //Initial game setup: deal two cards to player and dealer
            for(int i = 0; i < 2; i++){
                player1.deal(deck);
                dealer1.deal(deck);
            }

            //Check for 21 on initial deal
            if(player1.checkForBlackjack()){
                System.out.println("Player's Hand: " + player1.toString());
                System.out.println("BLACKJACK!!!");
                playerBlackjack = true;
            }

            //Determine if Dealer has a blackjack
            if(dealer1.checkForBlackjack()){
                System.out.println("Dealer's Hand: " + dealer1.toString());
                System.out.println("BLACKJACK!!!");
                if(!playerBlackjack){
                    dealerWin = true;
                }else{
                    gameDraw = true;
                    System.out.println("Draw!!");
                }
            }
            else{
                dealer1.printDealerHand();
            }

            //If both players didn't draw a blackjack the game will be played
            if(!gameDraw){
                //Player's turn from user input
                while(player1.playerTurn(in)){
                
                }
           
                //Player busted - Dealer wins
                if(player1.checkForBust()){
                    System.out.println("Dealer Wins!!");
                    dealerWin = true;
                }
                else{
                    dealer1.dealerTurn();
                }

                //Game Results
                if(!dealerWin){
                    if(dealer1.checkForBust() || player1.getTotal() > dealer1.getTotal()){
                        System.out.println("Player Wins!!");
                    }
                    else if(player1.getTotal() == dealer1.getTotal()){
                        System.out.println("Draw!!");
                    }
                    else{
                        System.out.println("Dealer Wins!!");
                    }
                }
            }
            
            System.out.println("Dealer's Hand: " + dealer1.toString() + " Total: " + dealer1.getTotal());
            System.out.println("Player's Hand: " + player1.toString() + " Total: " + player1.getTotal());
            System.out.println("-------------------------------------------------------------------------------");
            
            //Output and take user input for a new game
            System.out.println("Play again??" + "(Y/N)");
            playAgain = in.next().charAt(0);
            if(playAgain == 'Y'){
                newGame = true;
                dealerWin = false;
                player1.newHand();
                dealer1.newHand();
                //When there are less than half of the cards in the deck, a new deck will be played
                System.out.println("Cards left: " + deck.sizeOfDeck());
                if(deck.sizeOfDeck() < 26){
                    deck.newDeck();
                    System.out.println("New Deck!!");
                }
            }
            else if(playAgain == 'N'){
                newGame = false;
            }
        }
        in.close();
    }
}

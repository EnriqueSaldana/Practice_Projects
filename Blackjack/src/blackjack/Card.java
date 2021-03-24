package blackjack;

public class Card {
    private int value;   // 2-11
    private char rank;   // 2-10, J, Q, K, A
    private String suit; // Clubs, Diamonds, Hearts, Spades
    
    // Card Constructor with parameters
    public Card(int v, char r, String s){
        this.value = v;
        this.rank = r;
        this.suit = s;
    }

    //Returns value of card: 2-11
    public int getValue(){
        return this.value;
    }

    //Returns rank of card : 2-10, J, Q, K, A
    public char getRank(){
        return this.rank;
    }

    //Returns suit of card: Clubs, Diamonds, Hearts, Spades
    public String getSuit(){
        return this.suit;
    }

    //Returns String representation of a Card
    public String toString(){
        return ("[" + getRank() + " " + getSuit() + "]");
    }
}

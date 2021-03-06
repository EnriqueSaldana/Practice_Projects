package blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class test {

    @Test
    public void testCard(){
        Card test = new Card(10, 'K', "Hearts");
        assertEquals("[K Hearts]", test.toString());
    }

    @Test
    public void testDeckSize(){
        Deck deck = new Deck();
        assertEquals(52, deck.sizeOfDeck());
    }

    //Test to see if initial two cards dealt resulted in a BlackjackS
    @Test
    public void testBlackjack(){
        Hand hand = new Hand();
        hand.dealCard(new Card(10, 'K', "Hearts"));
        hand.dealCard(new Card(11, 'A', "Hearts"));

        Assert.assertTrue(hand.checkForBlackjack());
    }

    //Test to see if all cards are present in the deck
    //@Test
    //public void printDeck(){
    //    Deck deck1 = new Deck();
    //    Card card1;
    //    for(int i = 0; i < deck1.sizeOfDeck(); i++){
    //        card1 = deck1.getCardAtIndex(i);
    //        System.out.println(card1.toString());
    //    }
    //}
}
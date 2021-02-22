package blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class test {

    @Test
    public void testCard(){
        Card test = new Card(10, 'K', "Hearts");
        assertEquals("10 K Hearts", test.toString());
    }
}

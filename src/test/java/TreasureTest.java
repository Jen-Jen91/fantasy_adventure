import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreasureTest {
    Treasure treasure;

    @Before
    public void before(){
        treasure = new Treasure("Gold", 50);
    }

    @Test
    public void canGetType(){
        assertEquals("Gold", treasure.getType());
    }

    @Test
    public void canGetValue(){
        assertEquals(50, treasure.getValue());
    }
}

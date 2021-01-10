import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

public class TripTest {

    @Test
    public void getAdultPrice() {
        Trip trip = new Trip("abc", 10, 1,1,2,1, 21);
        assertNotNull(trip);
        assertEquals(29.04, trip.getTotal(), 0.1);
    }

    @Test
    public void getBagPrice() {
        Trip trip = new Trip("abc", 10, 1,1,2,1, 21);
        assertEquals(3.63, trip.getBagPrice(1), 0.1);
        assertEquals(7.26, trip.getBagPrice(2), 0.1);
    }

    @Test
    public void getChildPrice() {
        Trip trip = new Trip("abc", 10, 1,1,2,1, 21);
        assertEquals(6.05, trip.getChildPrice(), 0.1);
    }

    @Test
    public void getTotal() {
        Trip trip = new Trip("abc", 10, 1,1,2,1, 21);
        assertEquals(29.04, trip.getTotal(), 0.1);
    }

}
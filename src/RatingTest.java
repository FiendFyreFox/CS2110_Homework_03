import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatingTest {
    User testUser;
    Rating r1;

    @Before
    public void setup() {
        testUser = new User("oli");
        r1 = new Rating(testUser, 12);
    }

    @Test
    public void equalsTest() {
        Rating r2 = new Rating();
        assertNotEquals(r1, r2);
    }

    @Test
    public void toStringTest() {
        assertEquals("oli rates 1", r1.toString());
    }

    @Test
    public void setRatingTest() {
        r1.setRating(-12);
        assertEquals(-1, r1.getScore());
    }

    @Test
    public void setAndGetScoreTest() {
        r1.setScore(0);
        assertEquals(0, r1.getScore());
    }

    @Test
    public void setAndGetUserTest() {
        User jorge = new User("jorge");
        r1.setUser(jorge);
        assertEquals(jorge, r1.getUser());
    }
}
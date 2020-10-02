import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    User testUser;
    Meme testMeme;

    @Before
    public void setUp() throws Exception {
        testUser = new User("John");
        testMeme = new Meme(new BackgroundImage(), "test", new User("Harry"));
    }

    @Test
    public void rateMemeTest() {
        // We have not implemented this function yet, my implementation is only for testing purposes and does not need to be tested
    }

    @Test
    public void createMemeTest() {
        testUser.createMeme(new BackgroundImage(), "test");
        assertEquals(" <> 'test' John (0.0) 0.0 [(0) +1 (0) -1]", testUser.createMeme(new BackgroundImage(), "test").toString());
    }

    @Test
    public void deleteMemeTest() {
        BackgroundImage test = new BackgroundImage();
        Meme meme = testUser.createMeme(test, "test");
        boolean didContain = testUser.getMemesCreated().contains(meme);
        testUser.deleteMeme(meme);
        assertTrue(didContain && !testUser.getMemesCreated().contains(meme));
    }

    @Test
    public void shareMemeTest() {
        Feed testFeed = new Feed();
        testUser.shareMeme(testMeme, testFeed);
        Meme actual = testFeed.getMemes().get(0);
        assertEquals(testMeme, actual);
    }

    @Test
    public void rateNextMemeTest() {
        Feed testFeed = new Feed();
        User u2 = new User();
        Meme meme = u2.createMeme(new BackgroundImage(), "test");
        u2.shareMeme(meme, testFeed);
        testUser.rateNextMeme(testFeed, 4);
        assertEquals(1, meme.getRatings().get(0).getScore());
    }

    @Test
    public void calculateReputationTest() {
        Meme meme = testUser.createMeme(new BackgroundImage(), "test");
        testUser.rateMeme(meme, -3);
        assertEquals(-1, testUser.calculateReputation(), 0.1);
    }

    @Test
    public void testToStringTest() {

    }

    @Test
    public void testEqualsTest() {
    }

    @Test
    public void setUserNameTest() {
    }

    @Test
    public void setMemesCreatedTest() {
    }

    @Test
    public void setMemesViewedTest() {
    }
}
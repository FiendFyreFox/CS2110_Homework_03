import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FeedTest {

    Feed testFeed;
    User testUser;
    Meme testMeme;

    @Before
    public void setUp() throws Exception {
        testFeed = new Feed();
        Feed testFeed2 = new Feed(new ArrayList<Meme>());
        testUser = new User("Mark");
        testMeme = new Meme(new BackgroundImage(), "test", testUser);
    }

    @Test
    public void getNewMemeTest() {
        testUser.shareMeme(testMeme, testFeed);
        User t2 = new User();
        assertEquals(testMeme, testFeed.getNewMeme(t2));
    }

    @Test
    public void getNewMemeNullTest() {
        testUser.shareMeme(testMeme, testFeed);
        User t2 = new User();
        t2.getMemesViewed().add(testMeme);
        assertNotEquals(testMeme, testFeed.getNewMeme(t2));
    }

    @Test
    public void toStringTest() {
        testUser.shareMeme(testMeme, testFeed);
        boolean check = testFeed.toString().equals(" <> 'test' Mark (0.0) 0.0 [(0) +1 (0) -1]\n");
        assertTrue(check);
    }

    @Test
    public void setAndGetMemesTest() {
        ArrayList<Meme> memes = new ArrayList<>();
        Meme m1 = new Meme(new BackgroundImage(), "test 1", testUser);
        Meme m2 = new Meme(new BackgroundImage(), "test 2", testUser);
        memes.add(m1);
        memes.add(m2);

        testFeed.setMemes(memes);
        assertEquals(memes, testFeed.getMemes());
    }
}
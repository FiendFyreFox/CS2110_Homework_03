import java.util.ArrayList;

import static org.junit.Assert.*;

public class MemeTest {

    Meme testMeme;
    Meme testMeme2;
    User rater;

    @org.junit.Before
    public void setup() {
        testMeme = new Meme();
        testMeme2 = new Meme();

        rater = new User("TestMan");
        rater.rateMeme(testMeme, 7);
    }

    @org.junit.Test
    public void EqualsTest() {

        assertEquals("the two memes should be equal but are not", testMeme, testMeme2);
    }

    @org.junit.Test
    public void ToStringTest() {
        testMeme.setCaption("test");
        testMeme.getBackgroundImage().setDescription("test");
        assertEquals("expected return was not given", " <test> 'test'  (0.0) 1.0 [(1) +1 (0) -1]", testMeme.toString());
    }

    @org.junit.Test
    public void calculateRatingTest() {
        assertEquals(1.0, testMeme.calculateRating(), 0.1);
    }

    @org.junit.Test
    public void calculatePositiveRatingsTest() {
        assertEquals(1, testMeme.calculatePositiveRatings(testMeme.getRatings()), 0.1);
    }

    @org.junit.Test
    public void calculateNegativeRatingsTest() {
        rater.rateMeme(testMeme, -5);
        assertEquals(1, testMeme.calculateNegativeRatings(testMeme.getRatings()), 0.1);
    }

    @org.junit.Test
    public void setAndGetCreatorTest() {
        User testCreator = new User("marko");
        Meme meme = new Meme(new BackgroundImage(), "", new User());
        meme.setCreator(testCreator);
        assertEquals(testCreator, meme.getCreator());

    }

    @org.junit.Test
    public void setAndGetBackgroundImageTest() {
        Meme meme = new Meme(new User(), new BackgroundImage(), new ArrayList<Rating>(), "", false);
        BackgroundImage image = new BackgroundImage();
        meme.setBackgroundImage(image);
        assertEquals(image, meme.getBackgroundImage());
    }

    @org.junit.Test
    public void setAndGetRatingsTest() {
        Meme meme = new Meme();
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        ratings.add(new Rating(rater, 5));
        meme.setRatings(ratings);
        assertEquals(ratings, meme.getRatings());
    }

    @org.junit.Test
    public void setAndGetCaptionTest() {
        Meme meme = new Meme();
        String caption = "walking around";
        meme.setCaption(caption);
        assertEquals(caption, meme.getCaption());
    }

    @org.junit.Test
    public void setAndGetSharedTest() {
        Meme meme = new Meme();
        meme.setShared(true);
        assertTrue(meme.getShared());
    }
}
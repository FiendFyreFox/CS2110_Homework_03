/**

 * @author taogroves

 * 09/18/2020

 * Meme class, the image/text based humor on which modern society runs.

 */

import java.util.ArrayList;

public class Meme {
    private User creator;
    private BackgroundImage backgroundImage;
    private ArrayList<Rating> ratings;
    private String caption;
    private boolean shared;

    public Meme() {
        this.creator = new User();
        this.backgroundImage = new BackgroundImage("", "", "");
        this.caption = "";

        this.ratings = new ArrayList<Rating>();
        this.shared = false;
    }

    public Meme(BackgroundImage backgroundImage, String caption, User creator) {
        this.creator = creator;
        this.backgroundImage = backgroundImage;
        this.caption = caption;

        this.ratings = new ArrayList<Rating>();
        this.shared = false;
    }
    /**
     * constructor
     * @param creator
     * the creator of the meme
     * @param backgroundImage
     * the background of the meme
     * @param ratings
     * a list of all ratings the meme has recieved
     * @param caption
     * the caption of the meme
     * @param shared
     * whether the meme has been shared or not
     */
    public Meme(User creator, BackgroundImage backgroundImage, ArrayList<Rating> ratings, String caption, boolean shared) {
        this.creator = creator;
        this.backgroundImage = backgroundImage;
       this.ratings = ratings;
        this.caption = caption;
        this.shared = shared;
    }

    /**
     *
     * @param obj
     * the meme to compare
     * @return whether the memes are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Meme)) {
            return false;
        }
        Meme meme = (Meme) obj;
        return this.creator.equals(meme.creator) && this.caption.equals(meme.caption) && this.backgroundImage.equals(meme.backgroundImage);
    }

    @Override
    public String toString() { //TODO decide whether there should be 7 or 8 arguments

        return String.format("%s '%s' %s (%s) %s [(%s) +1 (%s) -1]", backgroundImage, caption, creator.getUserName(), creator.calculateReputation(), calculateRating(), (int) calculatePositiveRatings(this.ratings), (int) calculateNegativeRatings(this.ratings));
    }

    /**
     * finds the sum of all ratings a meme has received
     * @return
     * the sum of all ratings
     */
    public double calculateRating() {
        double sum = 0.0;
        //System.out.println(this.ratings.size());
        if (this.ratings.size() > 0) {
            for (Rating rating : this.ratings) {
                sum += rating.getScore();
            }
        }
        //System.out.println(sum);
        return sum;
    }

    /**
     * finds the total amount of positive ratings a meme has received
     * @param ratings
     * the list of all ratings
     * @return
     * the amount of  positive ratings
     */
    public double calculatePositiveRatings(ArrayList<Rating> ratings) {
        double sum = 0.0;

        for (Rating rating : ratings) {
            if (rating.getScore() == 1.0 || rating.getScore() == 1) {
                sum += rating.getScore();
            }
        }

        return sum;
    }

    /**
     * finds the total amount of negative ratings a meme has received
     * @param ratings
     * the list of all ratings
     * @return
     * the amount of negative ratings
     */
    public double calculateNegativeRatings(ArrayList<Rating> ratings) {
        double sum = 0.0;

        for (Rating rating : ratings) {
            if (rating.getScore() == -1.0 || rating.getScore() == -1) {
                sum -= rating.getScore();
            }
        }

        return sum;
    }

    /**
     *
     * @return the meme's creator
     */
    public User getCreator() {
        return creator;
    }

    /**
     * set the meme's creator
     * @param creator
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     *
     * @return the background image used in the meme
     */
    public BackgroundImage getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * set the background image for the meme
     * @param backgroundImage
     */
    public void setBackgroundImage(BackgroundImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    /**
     *
     * @return a list of all ratings the meme has received
     */
    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    /**
     * set the ratings the meme has received
     * @param ratings
     */
    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    /**
     * @return the caption of the meme
     */
    public String getCaption() {
        return caption;
    }

    /**
     * set the meme's caption
     * @param caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     *
     * @return whether the meme has been shared or not
     */
    public boolean getShared() {
        return shared;
    }

    /**
     * set whether the meme has been shared
     * @param shared
     */
    public void setShared(boolean shared) {
        this.shared = shared;
    }
}

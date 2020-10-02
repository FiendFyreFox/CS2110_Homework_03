/**

 * @author taogroves

 * 09/18/2020

 * User class, used to store information about each user of the network.

 */

import java.util.ArrayList;

public class User {
    private String userName;
    private ArrayList<Meme> memesCreated;
    private ArrayList<Meme> memesViewed;

    public User() {
        this.userName = "";
        this.memesCreated = new ArrayList<Meme>();// TODO fix these if needed
        this.memesViewed = new ArrayList<Meme>();
    }

    public User(String name) {
        this.userName = name;
        this.memesCreated = new ArrayList<Meme>();// TODO fix these if needed
        this.memesViewed = new ArrayList<Meme>();
    }
    /**
     * constructor
     * @param name
     * the name of the user
     * @param created
     * a list of memes the user has created
     * @param viewed
     * a list of memes the user has biewd
     */
    public User (String name, ArrayList<Meme> created, ArrayList<Meme> viewed) {
        this.userName = name;
        this.memesCreated = created;// TODO fix these if needed
        this.memesViewed = viewed;
    }

    /**
     * attaches a rating to a meme
     * @param meme
     * the meme to be rated
     * @param rating
     * the rating to apply
     */
    public void rateMeme(Meme meme, int rating) {
        meme.getRatings().add(new Rating(this, rating));
    }

    /**
     * creates a meme using an image and a string
     * @param image
     * the background image to use
     * @param caption
     * the caption to use
     * @return the completed meme
     *
     */
    public Meme createMeme(BackgroundImage image, String caption) {
        Meme newMeme = new Meme(image, caption, this);
        this.getMemesCreated().add(newMeme);
        return newMeme;
    }

    /**
     * deletes a meme
     * @param meme
     * the meme to delete
     * @return returns whether the operation was successful
     */
    public boolean deleteMeme(Meme meme) {
        if (this.memesCreated.contains(meme) && !meme.getShared()) {
            this.memesCreated.remove(meme);
        }

        return true;
    }

    /**
     * shares a meme to a feed
     * @param meme
     * the meme to share
     * @param feed
     * the feed to add it to
     */
    public void shareMeme(Meme meme, Feed feed) {
        meme.setShared(true);
        ArrayList<Meme> memesOnFeed;
        if (feed.getMemes() == null) {
            memesOnFeed = new ArrayList<Meme>();
        } else {
            memesOnFeed = feed.getMemes();
        }
        memesOnFeed.add(meme);
        feed.setMemes(memesOnFeed);
    }

    /**
     * rates the next meme in a feed
     * @param feed
     * @param ratingScore
     * the rating to give the meme
     */
    public void rateNextMeme(Feed feed, int ratingScore) {
        if (feed.getNewMeme(this) == null) {
            System.out.println("Error: no memes left to view for user " + this.toString());
            return;
        }
        Meme meme = feed.getNewMeme(this);

       this.getMemesViewed().add(meme);

        ArrayList<Rating> newRatings;
       if (meme.getRatings() == null) {
           newRatings = new ArrayList<Rating>();
       } else {
           newRatings = meme.getRatings();
       }
       newRatings.add(new Rating(this, ratingScore));
       meme.setRatings(newRatings);
    }

    /**
     * calculates the reputation of something
     * @return returns a numerical representation of the reputation
     */
    public double calculateReputation() {
        double reputation = 0.0;

        if (this.memesCreated.size() > 0) {
            for (Meme meme : this.memesCreated) {
                reputation += meme.calculateRating();
            }
        }

        return reputation;
    }

    @Override
    public String toString() {
        return String.format("%s has rated (%s) memes, (%s)", this.userName, this.memesViewed.size(), this.calculateReputation());
        // return this.userName + " has rated (" + this.memesViewed.size() + "), (" + this.calculateReputation() + ")";
    }

    /**
     *
     * @param obj
     * the user to compare
     * @return whether the users are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;

        return this.getUserName().equals(user.getUserName());
    }

    /**
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * set the user's username
     * @param userName
     * the new name to apply
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return the memes the user has created
     */
    public ArrayList<Meme> getMemesCreated() {
        return memesCreated;
    }

    /**
     * set the memes the user has created
     * @param memesCreated
     * the new list of memes to apply
     */
    public void setMemesCreated(ArrayList<Meme> memesCreated) {
        this.memesCreated = memesCreated;
    }

    /**
     *
     * @return the memes the user has viewed
     */
    public ArrayList<Meme> getMemesViewed() {
        return memesViewed;
    }

    /**
     * set the memes the user has viewed
     * @param memesViewed the new list of memes to apply
     */
    public void setMemesViewed(ArrayList<Meme> memesViewed) {
        this.memesViewed = memesViewed;
    }
}

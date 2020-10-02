/**

 * @author taogroves

 * 09/18/2020

 * Rating classs; users can create Ratings for memes which describe sentiment.

 */

public class Rating {
    private int score = 0;
    private User user = new User();

    public Rating() {}
    /**
     * constructor
     * @param score
     * the rating value
     * @param user
     * the user who gave the rating
     */
    public Rating(User user, int score) {
        this.score = setRating(score);
        this.user = user;
    }

    /**
     *
     * @param obj
     * the rating to compare
     * @return whether the ratings are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rating)) {
            return false;
        }
        Rating rating = (Rating) obj;
        return this.score == rating.getScore() && this.user.equals(rating.getUser());
    }

    @Override
    public String toString() {
        return this.user.getUserName() + " rates " + this.score;
    }

    /**
     * takes in an integer and returns a corresponding score
     * @param score
     * the input int
     * @return the score compressed and cast to an int
     */
    public int setRating(int score) {
        int rating = 0;
        if (score < 0) {
            rating = -1;
        } else if (score > 0) {
            rating = 1;
        }
        this.score = rating;
        return rating; // TODO should this be the rating's rating?
    }

    /**
     *
     * @return the value of the rating
     */
    public int getScore() {
        return score;
    }

    /**
     * set the rating
     * @param score
     */
    public void setScore(int score) {
        this.score = setRating(score);
    }

    /**
     *
     * @return the user who gave the rating
     */
    public User getUser() {
        return user;
    }

    /**
     * set the user who gave the rating
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
}

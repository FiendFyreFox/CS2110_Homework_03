/**

 * @author taogroves

 * 09/18/2020

 * Feed class, used to create a list of Memes for a user to view sequentially.

 */

import java.util.ArrayList;
import java.util.Random;

public class Feed {

    private ArrayList<Meme> memes;

    public Feed() {
        this. memes = new ArrayList<Meme>();
    }
    /**
     * constructor
     * @param memes
     * a list of memes in the feed
     */
    public Feed(ArrayList<Meme> memes) {
        this.memes = memes;
    }

    /**
     * get a new meme to show to the user
     * @param user
     * the user to generate the feed for
     * @return the new feed
     */
    public Meme getNewMeme(User user) {
        for (Meme meme : this.memes) {
            if (!user.getMemesCreated().contains(meme) && !user.getMemesViewed().contains(meme)) {
                return meme;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String output = "";

        for (Meme meme : this.memes) {
            output += meme.toString();
            output += "\n";

        }
        return output;
    }

    /**
     *
     * @return the feed of memes
     */
    public ArrayList<Meme> getMemes() {
        return memes;
    }

    /**
     * set which memes are in the feed
     * @param memes
     */
    public void setMemes(ArrayList<Meme> memes) {
        this.memes = memes;
    }
}
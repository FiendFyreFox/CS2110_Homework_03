/**

 * @author taogroves

 * 09/18/2020

 * BackgroundImage class, used to store background images for memes.

 */

public class BackgroundImage {
    private String imageFileName = "";
    private String title = "";
    private String description = "";

    public BackgroundImage() {}
    /**
     * constructor
     * @param imageFileName
     * the file name of the image
     * @param title
     * the title of the image
     * @param description
     * the description of the image
     */
    public BackgroundImage(String imageFileName, String title, String description) {
        this.imageFileName = imageFileName;
        this.title = title;
        this.description = description;
    }

    /**
     *
     * @param obj
     * the object to compare
     * @return whether the images are the same
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BackgroundImage)) {
            return false;
        }
        BackgroundImage image = (BackgroundImage) obj;

        return this.description.equals(image.description) && this.title.equals(image.title) && this.imageFileName.equals(image.imageFileName);
    }

    @Override
    public String toString() {
        String toReturn = String.format("%s <%s>", title, description);
        return toReturn;
    }

    /**
     *
     * @return the file name of the image
     */
    public String getImageFileName() {
        return imageFileName;
    }

    /**
     * set the filename
     * @param imageFileName
     * the new filename to apply
     */
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    /**
     *
     * @return the title of the image
     */
    public String getTitle() {
        return title;
    }

    /**
     * set the title of the image
     * @param title
     * the new title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return the description of the image
     */
    public String getDescription() {
        return description;
    }

    /**
     * set the description of the image
     * @param description
     * the new description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

package hakanbey;

public class Haber extends Channel {

    private String category;
    private String title;
    private String description;
    private String pubDate;
    private String image;
    private String mediaContent;
    private String mediaThumbnail;
    private String enclosure;
    private String link;
    private String guid;

    public Haber() {
    }

    public Haber(String category, String title, String description, String pubDate, String image, String mediaContent, String mediaThumbnail, String enclosure, String link, String guid) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.image = image;
        this.mediaContent = mediaContent;
        this.mediaThumbnail = mediaThumbnail;
        this.enclosure = enclosure;
        this.link = link;
        this.guid = guid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMediaContent() {
        return mediaContent;
    }

    public void setMediaContent(String mediaContent) {
        this.mediaContent = mediaContent;
    }

    public String getMediaThumbnail() {
        return mediaThumbnail;
    }

    public void setMediaThumbnail(String mediaThumbnail) {
        this.mediaThumbnail = mediaThumbnail;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}

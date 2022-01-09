package model;

public class Manset {
    private String category;
    private String title;;
    private String description;
    private String pubDate;
    private String image;
    private String link;

    public Manset(String category, String title, String description, String pubDate, String image, String link) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.image = image;
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }
}


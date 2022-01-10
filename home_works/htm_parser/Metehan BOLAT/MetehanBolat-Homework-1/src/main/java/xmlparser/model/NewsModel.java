package xmlparser.model;

public class NewsModel {

    private final String category;
    private final String title;
    private final String description;

    public NewsModel(String category, String title, String description) {
        this.category = category;
        this.title = title;
        this.description = description;
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

}

package hakanbey;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private String title;
    private String link;
    private String description;
    private String language;
    private String copyright;
    private String category;
    private String lastBuildDate;
    private int ttl;
    private List<Haber> haberList;


    public Channel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public List<Haber> getHaberList() {
        //  Eğer liste oluşturulmadıysa, kullanabilmemiz için boş bir liste oluştur
        if (this.haberList == null)
            this.haberList = new ArrayList<>();
        return haberList;
    }

    public void setHaberList(List<Haber> haberList) {
        this.haberList = haberList;
    }
}

package xmlparser.applications;

import xmlparser.model.NewsModel;
import xmlparser.service.NewsXmlParser;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NewsApp {

    public void getNews(String category){
        AtomicInteger counter = new AtomicInteger();
        NewsXmlParser xmlParser = new NewsXmlParser();
        List<NewsModel> newsList = xmlParser.news();

        if (category.equals("hepsi")){
            newsList.forEach(item -> {
                counter.getAndIncrement();
                System.out.println("---------------------------------" + item.getCategory().replaceFirst(item.getCategory().substring(0,1), item.getCategory().substring(0,1).toUpperCase()) + " Kategorisi " + counter.get() + " --------------------------------------");
                System.out.println(item.getTitle());
                System.out.println(item.getDescription());
                System.out.println("\n");
            });
        }else if (category.equals("spor") || category.equals("ekonomi") || category.equals("haber") || category.equals("magazin")){
            newsList.stream().filter(item -> item.getCategory().contains(category)).forEach(item -> {
                counter.getAndIncrement();
                System.out.println("---------------------------------" + category.replaceFirst(category.substring(0,1), category.substring(0,1).toUpperCase()) + " Kategorisi " + counter.get() + " --------------------------------------");
                System.out.println(item.getTitle());
                System.out.println(item.getDescription());
                System.out.println("\n");
            });
        }
    }
}

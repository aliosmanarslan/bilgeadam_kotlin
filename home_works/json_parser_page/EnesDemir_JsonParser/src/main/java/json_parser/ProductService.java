package json_parser;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import product.ProductData;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductService {
    Map<String,String> hashmap = new HashMap<>();
    StringBuilder stringBuilder = new StringBuilder();
    String ref = "c7c2de28d81d3da4a386fc8444d574f2";
    public ProductService(){
        stringBuilder.append("https://www.jsonbulut.com/json/");
    }
    public ProductData productList(int start) throws IOException {
        try{
            String a = Integer.toString(start);
            stringBuilder.append("product.php");
            hashmap.put("ref",ref);
            hashmap.put("start",a);
            hashmap.put("count","3");
            String sbData = Jsoup.connect(stringBuilder.toString()).data(hashmap)
                    .ignoreContentType(true).timeout(15000).get().body().text();
            Gson gson = new Gson();
            return gson.fromJson(sbData, ProductData.class);
        }catch (Exception e){
            System.err.println("Product result error: " + e);
        }
        return null;
    }
}
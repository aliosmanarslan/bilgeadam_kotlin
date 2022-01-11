package json_parser;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import props.ProductData;

import java.util.HashMap;
import java.util.Map;

public class ProductService {

    StringBuilder stringBuilder = new StringBuilder();
    Map<String,String> map = new HashMap<>();
    String ref = "c7c2de28d81d3da4a386fc8444d574f2";

    public ProductService(){
        stringBuilder.append("https://www.jsonbulut.com/json/");
    }

    public ProductData productResult(String startVal){

        try{
            stringBuilder.append("product.php");
            map.put("ref",ref);
            map.put("start",startVal);
            map.put("count","3");

            String data = Jsoup.connect(stringBuilder.toString()).data(map).ignoreContentType(true)
                    .timeout(30000).get().body().text();


            Gson gson = new Gson();
            return gson.fromJson(data,ProductData.class);

        }catch (Exception exception){
            System.err.println("Product Result Error: " + exception);
        }
        return null;
    }
}

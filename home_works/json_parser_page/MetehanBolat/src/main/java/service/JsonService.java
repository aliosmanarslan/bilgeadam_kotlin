package service;

import com.google.gson.Gson;
import model.Bilgiler;
import model.Example;
import org.jsoup.Jsoup;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonService {

    Map<String, String> hm = new HashMap<>();
    StringBuilder st = new StringBuilder();
    String ref = "c7c2de28d81d3da4a386fc8444d574f2";

    public JsonService(){
        st.append("https://www.jsonbulut.com/json/");
    }

    public List<Bilgiler> getProduct(String start){

        try {
            st.append("product.php");
            hm.put("ref", ref);
            hm.put("start", start);
            hm.put("count", "3");

            String stData = Jsoup.connect(st.toString()).data(hm).ignoreContentType(true).timeout(15000).get().body().text();
            Gson gson = new Gson();
            Example example = gson.fromJson(stData, Example.class);

            return example.getProducts().get(0).getBilgiler();

        }catch (Exception ex){
            System.out.println("Product Error: " + ex);
            return Collections.emptyList();
        }
    }

}

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.jsoup.Jsoup;
import product.ProductData;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.StringReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class ProductService {
    Map<String,String> hm = new HashMap<>();
    String ref = "c7c2de28d81d3da4a386fc8444d574f2";
    StringBuilder st = new StringBuilder();

    public ProductService(){
        String baseUrl = "https://www.jsonbulut.com/json/";
        st.append(baseUrl);
    }

    public ProductData productResult(String start){
        try {
            st.append("product.php");
            hm.put("ref",ref);
            hm.put("start",start);
            hm.put("count","3");

            String stData = Jsoup.connect(st.toString()).data(hm).ignoreContentType(true).timeout(15000)
                    .sslSocketFactory(socketFactory()).get().body().text();

            //System.out.println(stData);
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new StringReader(stData));
            reader.setLenient(true);
            return gson.fromJson(reader, ProductData.class);

        }catch (Exception ex){
            System.out.println("Product Result ERROR : " + ex );
        }
        return null;
    }

    static private SSLSocketFactory socketFactory() {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            SSLSocketFactory result = sslContext.getSocketFactory();

            return result;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to create a SSL socket factory", e);
        }
    }
}

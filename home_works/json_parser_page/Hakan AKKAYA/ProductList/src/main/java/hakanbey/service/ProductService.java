package hakanbey.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hakanbey.model.ProductData;
import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductService {

    //  Api Domain
    StringBuilder BASE_URL, BASE_URL_TEMP;
    //  Ref
    private static final String REF = "c7c2de28d81d3da4a386fc8444d574f2";
    //  HashMap
    Map<String, String> hm;


    public ProductService() {
        this.BASE_URL = new StringBuilder("https://www.jsonbulut.com/json/");
        this.BASE_URL_TEMP = new StringBuilder(BASE_URL);
        this.hm = new HashMap<>();
    }


    public ProductData getProducts(int start) {
        try {
            //  Verilerin çekileceği adres
            BASE_URL = new StringBuilder(BASE_URL_TEMP);
            BASE_URL.append("product.php");

            //  HashMap
            hm.put("ref", REF);
            hm.put("start", String.valueOf(start));
            hm.put("count", "3");

            String productData = Jsoup.connect(BASE_URL.toString()).data(hm).ignoreContentType(true).timeout(15000).sslSocketFactory(socketFactory()).get().body().text().replace("\\", "");

            Gson gson = new Gson();
            return gson.fromJson(productData, ProductData.class);
        } catch (Exception e) {
            System.err.println("getProduct Hata: " + e);
            return null;
        }
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

            return sslContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to create a SSL socket factory", e);
        }
    }
}

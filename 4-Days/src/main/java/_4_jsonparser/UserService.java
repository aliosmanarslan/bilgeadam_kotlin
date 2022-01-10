package _4_jsonparser;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import props.login.User;
import props.login.UserLogin;
import props.product.ProductData;
import props.register.UserRegister;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    Map<String, String> hm = new HashMap<>();
    StringBuilder st = new StringBuilder();
    String ref = "c7c2de28d81d3da4a386fc8444d574f2";
    public UserService() {
        st.append("https://www.jsonbulut.com/json/");
    }


    // user login
    public User login( String userEmail, String userPass ) {

        try {
            // url
            st.append("userLogin.php");
            hm.put("ref",ref);

            // send data
            hm.put("userEmail", userEmail);
            hm.put("userPass", userPass);
            hm.put("face", "no");

            String stData = Jsoup.connect(st.toString()).data(hm).ignoreContentType(true).timeout(15000).sslSocketFactory(socketFactory()).get().body().text();
            Gson gson = new Gson();
            UserLogin userLogin = gson.fromJson(stData, UserLogin.class);
            User u = userLogin.getUser().get(0);
            return u;
            /*
            boolean durum = u.getDurum();
            String message = u.getMesaj();
            System.out.println( durum );
            System.out.println( message );

            if ( u.getBilgiler() != null ) {
                Bilgiler bilgiler = u.getBilgiler();
                System.out.println( bilgiler.getUserName() );
            }
             */

        }catch (Exception ex) {
            System.err.println("login Error: " + ex);
            return null;
        }

    }


    public UserRegister register( String userName, String userSurname, String userPhone, String userMail, String userPass ) {
        try {
            st.append("userRegister.php");
            hm.put("ref",ref);

            hm.put("userName", userName);
            hm.put("userSurname", userSurname);
            hm.put("userPhone", userPhone);
            hm.put("userMail", userMail);
            hm.put("userPass", userPass);

            String stData = Jsoup.connect(st.toString()).data(hm).ignoreContentType(true).timeout(15000).sslSocketFactory(socketFactory()).get().body().text();
            Gson gson = new Gson();
            return gson.fromJson(stData, UserRegister.class);
        }catch (Exception ex) {
            System.err.println("Register Error : " + ex);
        }
        return null;
    }


    // product
    public ProductData productResult() {
        try {

            st.append("product.php");
            hm.put("ref",ref);
            hm.put("start","0");

            String stData = Jsoup.connect(st.toString()).data(hm).ignoreContentType(true).timeout(15000).sslSocketFactory(socketFactory()).get().body().text();
            Gson gson = new Gson();
            return gson.fromJson(stData, ProductData.class);
        }catch (Exception ex) {
            System.err.println("productResult Error : " + ex);
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

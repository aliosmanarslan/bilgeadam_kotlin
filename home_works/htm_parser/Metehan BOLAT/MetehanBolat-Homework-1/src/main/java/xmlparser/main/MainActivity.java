package xmlparser.main;

import xmlparser.applications.NewsApp;
import xmlparser.applications.WeatherApp;
import xmlparser.timer.Timer;
import java.util.Scanner;

public class MainActivity {

    public static void main(String[] args) {

        while(true){
            Scanner userInput = new Scanner(System.in);
            System.out.println("Hava Durumu -> 1 \nHaber -> 2\nLütfen 1 veya 2 yazın.");
            String text = userInput.next().toLowerCase();
            if (text.equals("1")){
                System.out.println("Hangi şehir için hava durumu raporunu istiyorsunuz. Aşağıda listelenen şehirlerden birini seçin veya hepsi diyerek tüm şehirlere ulaşabilirsiniz.");
                System.out.println("Mevcut şehirler yükleniyor lütfen bekleyin...");
                WeatherApp weatherApp = new WeatherApp();
                System.out.println(weatherApp.getCities());
                Scanner weatherInput = new Scanner(System.in);
                String weatherText = weatherInput.next().toUpperCase();
                weatherApp.getWeather(weatherText);
                break;
            }else if (text.equals("2")){
                int counter = 2;
                while (true){
                    System.out.println("Ne tür haberler istiyorsunuz? Lütfen aşağıdakilerden birini yazın.\nHepsi-Spor-Ekonomi-Magazin-Haber");
                    Scanner newsInput = new Scanner(System.in);
                    String newsText = newsInput.next().toLowerCase();
                    if (newsText.equals("hepsi") || newsText.equals("spor") ||newsText.equals("haber") ||newsText.equals("ekonomi") || newsText.equals("magazin")){
                        NewsApp newsApp = new NewsApp();
                        newsApp.getNews(newsText);
                        break;
                    }else{
                        if (counter == 0){
                            System.out.println("Doğru bir kategori seçimi yapmadınız. Üzgünüz fakat uygulamanız kapatılıyor.");
                            Timer timer = new Timer();
                            timer.timer(3);
                            break;
                        }else{
                            System.out.println("Yanlış kategori yazıyorsunuz kalan hak: " + counter);
                        }
                    }
                    counter--;
                }
                break;
            }else{
                System.out.println("Lütfen hava durumu veya haber yazın.");
            }
        }
    }
}

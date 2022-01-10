package xmlparser.applications;

import xmlparser.model.WeatherModel;
import xmlparser.service.WeatherXmlParser;
import xmlparser.timer.Timer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class WeatherApp {

    public void getWeather(String city){
        WeatherXmlParser weatherXmlParser = new WeatherXmlParser();
        List<WeatherModel> weatherList = weatherXmlParser.weather();

        if (city.equals("HEPSI")){
            weatherList.forEach(item -> output(item.getCity(), item.getRegion(), item.getPeriod(), item.getMin(), item.getMax(), item.getSituation()));
        }else{
            AtomicBoolean control = new AtomicBoolean(false);
            weatherList.forEach(item -> {
                if (item.getCity().equalsIgnoreCase(city)){
                    control.set(true);
                    output(item.getCity(), item.getRegion(), item.getPeriod(), item.getMin(), item.getMax(), item.getSituation());
                }
            });
            if (!control.get()){
                System.out.println("Listede olmayan bir şehir girişi yaptınız.");
                Timer timer = new Timer();
                timer.timer(3);
            }
        }
    }

    public String getCities(){
        WeatherXmlParser weatherXmlParser = new WeatherXmlParser();
        List<WeatherModel> weatherList = weatherXmlParser.weather();
        StringBuffer cityList = new StringBuffer("Hepsi");

        weatherList.forEach(item -> {
            cityList.append(", ").append(item.getCity());
        });
        return cityList.toString();

    }

    public void output(String city, String region, String period, String min, String max, String situation){
        System.out.println("---------------------------------" + city + "-----------------------------------");
        System.out.println("Bölge: " + region);
        System.out.println("Zaman: " + period);
        System.out.println("En düşük: " + min);
        System.out.println("En yüksek: " + max);
        System.out.println("Tahmin: " + situation);
        System.out.println("\n");
    }

}
